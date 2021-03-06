package com.zeroquo.dottchallengescala.util

import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

object DateUtil {

  private val DEFAULT_DATE_TIME_FORMAT = "yyyy-MM-dd HH:mm:ss"

  def convertStringToLocalDateTime(date: String, format: String = DEFAULT_DATE_TIME_FORMAT): LocalDateTime = {
    try {
      val formatter = DateTimeFormatter.ofPattern(format)
      LocalDateTime.parse(date, formatter)
    } catch {
      case _ : Exception =>
        println("An error occurred while trying to parse the provided dates. \n"
          + "You Must Provide at least startDate and endDate, using LocalDateTime formats as: YYYY-MM-DD HH:MM:SS")
        LocalDateTime.now()
    }
  }
}
