package com.zeroquo.dottchallengescala.util

import java.time.LocalDateTime

import org.scalatest.flatspec.AnyFlatSpec

class DateUtilTest extends AnyFlatSpec {

  "DateUtil" should "return a date in a LocalDateTime format" in {

    val result = DateUtil.convertStringToLocalDateTime("2021-03-07 16:51:00")

    assert(result.isInstanceOf[LocalDateTime])
    assert(result.getMonthValue == 3)
    assert(result.getDayOfMonth == 7)
    assert(result.getYear == 2021)
    assert(result.getHour == 16)
    assert(result.getMinute == 51)
  }

  "DateUtil" should "return a date with a custom format" in {

    val result = DateUtil.convertStringToLocalDateTime("2021-03-07", "yyyy-MM-dd")

    assert(result.isInstanceOf[LocalDateTime])
    assert(result.getMonthValue == 3)
    assert(result.getDayOfMonth == 7)
    assert(result.getYear == 2021)
  }

  "DateUtil" should "return actual date when the date is out of format" in {

    val result = DateUtil.convertStringToLocalDateTime("202-03-07", "yyyy-MM-dd")

    assert(result.isInstanceOf[LocalDateTime])
    assert(result.getYear == 2021)
  }
}
