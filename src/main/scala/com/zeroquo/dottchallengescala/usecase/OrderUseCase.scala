package com.zeroquo.dottchallengescala.usecase

import java.time.LocalDateTime

import com.zeroquo.dottchallengescala.dataprovider.OrderDataProvider
import com.zeroquo.dottchallengescala.usecase.entity.{Interval, Order}

class OrderUseCase(orderDataProvider: OrderDataProvider = new OrderDataProvider) {

  def reportOldProductsSoldByDate(startDate: LocalDateTime, endDate: LocalDateTime, interval: List[Interval]): String = {
    (verifyDates(startDate, endDate), verifyInterval(interval)) match {
      case (Some(messageDate), Some(messageInterval)) => messageDate + messageInterval
      case (Some(messageDate), None) => messageDate
      case (None, Some(messageInterval)) => messageInterval
      case (None, None) =>
        val listOrders = orderDataProvider.getAllOrders

        val value = listOrders.filter(order => order.orderDate.isAfter(startDate))
          .filter(order => order.orderDate.isBefore(endDate))

        groupOrdersByInterval(value, interval)
    }
  }

  private def groupOrdersByInterval(orders: List[Order], intervals: List[Interval]): String = {

    val firstDayOfThisMonth = LocalDateTime.now.withDayOfMonth(1)
      .withHour(0)
      .withMinute(0)
      .withSecond(0)
      .withNano(0)

    intervals
      .map(interval => {
        var result = 0
        if (interval.isRangeType) {
          val list = orders
            .filter((order: Order) => order.items
              .exists(item => item.product.creationDate.isBefore(firstDayOfThisMonth.minusMonths(interval.startValue)) ||
                item.product.creationDate.isEqual(firstDayOfThisMonth.minusMonths(interval.startValue)) &&
                item.product.creationDate.isAfter(firstDayOfThisMonth.minusMonths(interval.endValue)) ||
                item.product.creationDate.isEqual(firstDayOfThisMonth.minusMonths(interval.endValue)))
            )

          //println(s"\n\n ${interval.rawValue} \n" + list.mkString("\n") + "\n\n")

          result = list.length
        } else {
          if (interval.isComparatorGreaterThan) {

            val list = orders.filter((order: Order) => order.items
              .exists(item => item.product.creationDate.isBefore(firstDayOfThisMonth.minusMonths(interval.edgeValue)) ||
                item.product.creationDate.isEqual(firstDayOfThisMonth.minusMonths(interval.edgeValue))))

            //println(s"\n\n ${interval.rawValue} \n" + list.mkString("\n") + "\n\n")

            result = list.length
          } else if (interval.isComparatorLessThan) {

            val list = orders.filter((order: Order) => order.items
              .exists(item => item.product.creationDate.isAfter(firstDayOfThisMonth.minusMonths(interval.edgeValue)) ||
                item.product.creationDate.isEqual(firstDayOfThisMonth.minusMonths(interval.edgeValue))))

            //println(s"\n\n ${interval.rawValue} \n" + list.mkString("\n") + "\n\n")

            result = list.length
          }
        }
        s"${interval.rawValue} months: $result"
      })
      .mkString("\n")
  }

  private def verifyDates(starDate: LocalDateTime, endDate: LocalDateTime): Option[String] =
    if (starDate.isBefore(endDate)) {
      None
    } else {
      Some(s"Start date must be before the End date")
    }

  private def verifyInterval(interval: List[Interval]): Option[String] = {
    val maybeStrings = interval.flatMap(interval => {
      if (interval.startValue >= 0 && interval.endValue >= 0 && interval.startValue <= interval.endValue)
        None
      else
        Some(s"Interval has incorrect value: ${interval.startValue}, ${interval.endValue}")
    }).mkString("\n")

    maybeStrings match {
      case "" => None
      case _ => Some(maybeStrings)
    }
  }

}
