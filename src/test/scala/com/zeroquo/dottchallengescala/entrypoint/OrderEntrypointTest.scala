package com.zeroquo.dottchallengescala.entrypoint

import com.zeroquo.dottchallengescala.usecase.OrderUseCase
import org.mockito.ArgumentMatchersSugar
import org.mockito.scalatest.MockitoSugar
import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.matchers.must.Matchers

class OrderEntrypointTest extends AnyFlatSpec with MockitoSugar with Matchers with ArgumentMatchersSugar {

  val orderUseCaseMock : OrderUseCase = mock[OrderUseCase]
  val orderEntrypoint : OrderEntrypoint = new OrderEntrypoint(orderUseCaseMock)

  "orderEntrypoint" should "report some successful value with given Entries" in {

    when(orderUseCaseMock.reportOldProductsSoldByDate(any, any, any)).thenReturn("Ok")

    val result = orderEntrypoint.reportOlderOrdersByDate(Array("2018-01-01 00:00:00", "2021-01-01 00:00:00", "1-4", ">8"))

    assert(result equals "Ok")
  }

  "orderEntrypoint" should "report some successful value with given Entries even when date is out of range" in {

    when(orderUseCaseMock.reportOldProductsSoldByDate(any, any, any)).thenReturn("Ok")

    val result = orderEntrypoint.reportOlderOrdersByDate(Array("9999-01-01 00:00:00", "2021-01-01 00:00:00", "1-4", "4-8"))

    assert(result equals "Ok")
  }

  "orderEntrypoint" should "report some successful value with given Entries without intervals" in {

    when(orderUseCaseMock.reportOldProductsSoldByDate(any, any, anyList)).thenReturn("Ok")

    val result = orderEntrypoint.reportOlderOrdersByDate(Array("2018-01-01 00:00:00", "2021-01-01 00:00:00"))

    assert(result equals "Ok")
  }

  "orderEntrypoint" must "Print Error when entries size are fewer than two" in {

    val result = orderEntrypoint.reportOlderOrdersByDate(Array("2018-01-01 00:00:00"))

    assert(result startsWith  "\nWrong parameters.")
  }

  "orderEntrypoint" must "Print Error when none entries are given" in {

    val result = orderEntrypoint.reportOlderOrdersByDate(Array())

    assert(result startsWith  "\nWrong parameters.")
  }

  "orderEntrypoint" must "Print Error when any date is out of format" in {

    val result = orderEntrypoint.reportOlderOrdersByDate(Array("18-01-01 00:00:00", "2021-01-01 00:00:00"))
    val result2 = orderEntrypoint.reportOlderOrdersByDate(Array("20180101 00:00:00", "2021-01-01 00:00:00"))
    val result3 = orderEntrypoint.reportOlderOrdersByDate(Array("2018/01/01 00:00:00", "2021-01-01 00:00:00"))
    val result4 = orderEntrypoint.reportOlderOrdersByDate(Array("2018-01-01 00:00:00", "2021-01-01"))
    val result5 = orderEntrypoint.reportOlderOrdersByDate(Array("2018-01-01 00:00:0", "2021-01-01 00:00:0"))
    val result6 = orderEntrypoint.reportOlderOrdersByDate(Array("2018-01-01 00:00:00", "2021-1-01 00:00:00", "1-2"))

    assert(result startsWith  "The current date is invalid:")
    assert(result2 startsWith  "The current date is invalid:")
    assert(result3 startsWith  "The current date is invalid:")
    assert(result4 startsWith  "The current date is invalid:")
    assert(result5 startsWith  "The current date is invalid:")
    assert(result6 startsWith  "The current date is invalid:")
  }

  "orderEntrypoint" must "Print Error when any interval is out of format" in {

    val result = orderEntrypoint.reportOlderOrdersByDate(Array("2018-01-01 00:00:00", "2021-01-01 00:00:00", "12"))
    val result2 = orderEntrypoint.reportOlderOrdersByDate(Array("2018-01-01 00:00:00", "2021-01-01 00:00:00", "1>2"))
    val result3 = orderEntrypoint.reportOlderOrdersByDate(Array("2018-01-01 00:00:00", "2021-01-01 00:00:00", "1-2", "-2"))
    val result4 = orderEntrypoint.reportOlderOrdersByDate(Array("2018-01-01 00:00:00", "2021-01-01 00:00:00", ">213"))
    val result5 = orderEntrypoint.reportOlderOrdersByDate(Array("2018-01-01 00:00:00", "2021-01-01 00:00:00", "<323"))
    val result6 = orderEntrypoint.reportOlderOrdersByDate(Array("2018-01-01 00:00:00", "2021-01-01 00:00:00", "234-432"))
    val result7 = orderEntrypoint.reportOlderOrdersByDate(Array("2018-01-01 00:00:00", "2021-01-01 00:00:00", "1-"))
    val result8 = orderEntrypoint.reportOlderOrdersByDate(Array("2018-01-01 00:00:00", "2021-01-01 00:00:00", "45<"))
    val result9 = orderEntrypoint.reportOlderOrdersByDate(Array("2018-01-01 00:00:00", "2021-01-01 00:00:00", "l-2"))

    assert(result startsWith  "\nThe given interval has incorrect format:")
    assert(result2 startsWith  "\nThe given interval has incorrect format:")
    assert(result3 startsWith  "\nThe given interval has incorrect format:")
    assert(result4 startsWith  "\nThe given interval has incorrect format:")
    assert(result5 startsWith  "\nThe given interval has incorrect format:")
    assert(result6 startsWith  "\nThe given interval has incorrect format:")
    assert(result7 startsWith  "\nThe given interval has incorrect format:")
    assert(result8 startsWith  "\nThe given interval has incorrect format:")
    assert(result9 startsWith  "\nThe given interval has incorrect format:")
  }
}
