package com.zeroquo.dottchallengescala.entrypoint

import com.zeroquo.dottchallengescala.usecase.OrderUseCase
import com.zeroquo.dottchallengescala.usecase.entity.Interval
import com.zeroquo.dottchallengescala.util.DateUtil

import scala.concurrent.ExecutionContext.Implicits.global
import scala.concurrent.Future

class OrderEntrypoint(orderUseCase: OrderUseCase = new OrderUseCase()) {

  val DATE_TIME_PATTERN = """^([0-9]{4})-([0-1][0-9])-([0-3][0-9])\s([0-1][0-9]|[2][0-3]):([0-5][0-9]):([0-5][0-9])$"""
  val INTERVAL_PATTERN = """^([0-9]{1,2})-([0-9]{1,2})$|^([<>][0-9]{1,2})$"""

  def reportOlderOrdersByDate(args: Array[String]): String = validateArgs(args) match {
    case Some(message) => message
    case None =>

      val (dates, intervals) = extractDatesAndIntervals(args)

      validateDate(dates) match {
        case Some(message) => message
        case _ =>

          val parsedIntervals = intervals
            .map(parseInterval)

          if (parsedIntervals.forall(_.isInstanceOf[Interval])) {

            val startDate = DateUtil.convertStringToLocalDateTime(dates(0))
            val endDate = DateUtil.convertStringToLocalDateTime(dates(1))
            var listIntervals = parsedIntervals.map(_.asInstanceOf[Interval]).toList

            if (listIntervals.isEmpty)
              listIntervals = defaultIntervals

            orderUseCase.reportOldProductsSoldByDate(startDate, endDate, listIntervals)
          } else {
            parsedIntervals.filter(_.isInstanceOf[String]).mkString(",")
          }
      }
  }

  private def defaultIntervals: List[Interval] =
    Interval(startValue = 1, endValue = 3, rawValue = "1-3") ::
      Interval(startValue = 4, endValue = 6, rawValue = "4-6") ::
      Interval(startValue = 7, endValue = 12, rawValue = "1-3") ::
      Interval(edgeValue = 12, comparator = ">", rawValue = ">12", isRangeType = false) :: Nil

  private def extractDatesAndIntervals(args: Array[String]): (Array[String], Array[String]) = args.splitAt(2)

  private def validateArgs(args: Array[String]): Option[String] = {
    if (args.length < 2) {
      Some("\nWrong parameters. \n"
        + "You Must Provide at least startDate and endDate, using LocalDateTime formats as: YYYY-MM-DD HH:MM:SS")
    } else {
      None
    }
  }

  private def validateDate(args: Array[String]): Option[String] = {

    val dateTimeRegex = DATE_TIME_PATTERN.r

    val maybeStrings = args
      .flatMap(date => dateTimeRegex.findFirstMatchIn(date) match {
        case Some(_) => None
        case None => Some(s"The current date is invalid: $date,\nuse this format: YYYY-MM-DD HH:MM:SS")
      })
      .mkString("\n")

    maybeStrings match {
      case "" => None
      case _ => Some(maybeStrings)
    }
  }

  private def parseInterval(range: String): Any =
    INTERVAL_PATTERN.r.findFirstMatchIn(range) match {
      case Some(value) if value.matched.contains("-") =>
        val parameters = value.matched.split("-")
        Interval(startValue = parameters(0).toInt, endValue = parameters(1).toInt, rawValue = value.matched)
      case Some(value) if value.matched.contains(">") || value.matched.contains("<") =>
        val parameters = value.matched
        Interval(comparator = parameters.substring(0, 1), edgeValue = parameters.substring(1).toInt,
          rawValue = value.matched, isRangeType = false)
      case _ =>
        s"\nThe given interval has incorrect format: $range, \nuse intervals like: 1-2, 1-12, >12, <3"
    }

}

object OrderEntrypoint {

  val orderEntrypoint = new OrderEntrypoint()

  def reportOlderOrdersByDate(args: Array[String]): Future[String] = Future {
    orderEntrypoint.reportOlderOrdersByDate(args)
  }

}
