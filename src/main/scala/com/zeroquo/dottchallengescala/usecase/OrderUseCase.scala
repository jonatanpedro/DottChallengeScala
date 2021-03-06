package com.zeroquo.dottchallengescala.usecase

import java.time.LocalDateTime

import com.zeroquo.dottchallengescala.dataprovider.OrderDataProvider
import com.zeroquo.dottchallengescala.usecase.entity.{Interval, Order}

class OrderUseCase {

  def reportOldProductsSoldByDate(startDate: LocalDateTime, endDate: LocalDateTime,
                                  interval: List[Interval] = Nil): String = {
    (verifyDates(startDate, endDate), verifyInterval(interval)) match {
      case (Some(messageDate), Some(messageInterval)) => messageDate + messageInterval
      case (Some(messageDate), None) => messageDate
      case (None, Some(messageInterval)) => messageInterval
      case (None, None) =>
        val listOrders = OrderDataProvider.getAllOrders
        val value = listOrders.filter(order => order.orderDate.isAfter(startDate))
          .filter(order => order.orderDate.isBefore(endDate))

        println(value.mkString("\n"))
        println(value.length)

        groupOrdersByInterval(value, interval)
    }
  }

  private def groupOrdersByInterval(orders: List[Order], intervals: List[Interval]): String = {

    intervals
      .map(interval => {
        var result = 0
        if (interval.isRangeType) {
          result = orders.count(order => order.items.
            exists(item => item.product.creationDate.isBefore(LocalDateTime.now.minusMonths(interval.startValue)) &&
              item.product.creationDate.isAfter(LocalDateTime.now.minusMonths(interval.endValue))))
        } else {
          if (interval.isComparatorGreaterThan)
            result = orders.count((order: Order) => order.items
              .exists(item => item.product.creationDate.isBefore(LocalDateTime.now.minusMonths(interval.edgeValue))))
          else if (interval.isComparatorLessThan)
            result = orders.count((order: Order) => order.items
              .exists(item => item.product.creationDate.isAfter(LocalDateTime.now.minusMonths(interval.edgeValue))))
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
