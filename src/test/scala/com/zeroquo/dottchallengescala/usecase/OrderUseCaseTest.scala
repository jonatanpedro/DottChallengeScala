package com.zeroquo.dottchallengescala.usecase

import java.time.{LocalDate, LocalDateTime, LocalTime, Month}

import com.zeroquo.dottchallengescala.dataprovider.OrderDataProvider
import com.zeroquo.dottchallengescala.usecase.entity.{Interval, Item, Order, Product}
import org.mockito.ArgumentMatchersSugar
import org.mockito.scalatest.MockitoSugar
import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.matchers.must.Matchers

class OrderUseCaseTest extends AnyFlatSpec with MockitoSugar with Matchers with ArgumentMatchersSugar {

  val orderDataProviderMock : OrderDataProvider = mock[OrderDataProvider]
  val orderUseCase : OrderUseCase = new OrderUseCase(orderDataProviderMock)

  "OrderUseCase" should "report some successful value with given Entries intervals" in {

    val listOrder = List(Order("Roger Waters", "rogerwaters@mail.com", "England",
      100.00, LocalDateTime.of(LocalDate.of(2020, Month.DECEMBER, 25),
        LocalTime.of(0, 0, 0)), List(Item(cost = 20.0, shippingFee = 3.0, taxAmount = 20.0,
        product = Product(name = "Overcooked (Team17)", category = "Game", weight = 20.0, price = 40.0,
          creationDate = LocalDateTime.of(LocalDate.of(2020, Month.DECEMBER, 1),
            LocalTime.of(0, 0, 0)))))))

    when(orderDataProviderMock.getAllOrders).thenReturn(listOrder)

    val startDate = LocalDateTime.of(LocalDate.of(2017, Month.JANUARY, 1), LocalTime.of(0, 0, 0))
    val endDate = LocalDateTime.of(LocalDate.of(2021, Month.JANUARY, 2), LocalTime.of(0, 0, 0))
    val intervalList = List(Interval(startValue = 1, endValue = 3, rawValue = "1-3"), Interval(startValue = 4, endValue = 6, rawValue = "4-6"))

    val result = orderUseCase.reportOldProductsSoldByDate(startDate, endDate, intervalList)

    assert(result equals "1-3 months: 1\n4-6 months: 0")
  }

  "OrderUseCase" should "report some successful value with given a value greater than three months" in {

    val listOrder = List(Order("Roger Waters", "rogerwaters@mail.com", "England",
      100.00, LocalDateTime.of(LocalDate.of(2020, Month.DECEMBER, 25),
        LocalTime.of(0, 0, 0)), List(Item(cost = 20.0, shippingFee = 3.0, taxAmount = 20.0,
        product = Product(name = "Overcooked (Team17)", category = "Game", weight = 20.0, price = 40.0,
          creationDate = LocalDateTime.of(LocalDate.of(2020, Month.SEPTEMBER, 1),
            LocalTime.of(0, 0, 0)))))))

    when(orderDataProviderMock.getAllOrders).thenReturn(listOrder)

    val startDate = LocalDateTime.of(LocalDate.of(2017, Month.JANUARY, 1), LocalTime.of(0, 0, 0))
    val endDate = LocalDateTime.of(LocalDate.of(2021, Month.JANUARY, 2), LocalTime.of(0, 0, 0))
    val intervalList = List(Interval(edgeValue = 3, comparator=">", rawValue = ">3"))

    val result = orderUseCase.reportOldProductsSoldByDate(startDate, endDate, intervalList)

    assert(result equals ">3 months: 1")
  }

  "OrderUseCase" should "report some successful value with given a value lesser than three months" in {

    val listOrder = List(Order("Roger Waters", "rogerwaters@mail.com", "England",
      100.00, LocalDateTime.of(LocalDate.of(2020, Month.DECEMBER, 25),
        LocalTime.of(0, 0, 0)), List(Item(cost = 20.0, shippingFee = 3.0, taxAmount = 20.0,
        product = Product(name = "Overcooked (Team17)", category = "Game", weight = 20.0, price = 40.0,
          creationDate = LocalDateTime.of(LocalDate.of(2021, Month.JANUARY, 1),
            LocalTime.of(0, 0, 0)))))))

    when(orderDataProviderMock.getAllOrders).thenReturn(listOrder)

    val startDate = LocalDateTime.of(LocalDate.of(2017, Month.JANUARY, 1), LocalTime.of(0, 0, 0))
    val endDate = LocalDateTime.of(LocalDate.of(2021, Month.JANUARY, 2), LocalTime.of(0, 0, 0))
    val intervalList = List(Interval(edgeValue = 3, comparator="<", rawValue = "<3"))

    val result = orderUseCase.reportOldProductsSoldByDate(startDate, endDate, intervalList)

    assert(result equals "<3 months: 1")
  }

  "OrderUseCase" should "report some an error when a given start date is greater than end date" in {

    val listOrder = List(Order("Roger Waters", "rogerwaters@mail.com", "England",
      100.00, LocalDateTime.of(LocalDate.of(2020, Month.DECEMBER, 25),
        LocalTime.of(0, 0, 0)), List(Item(cost = 20.0, shippingFee = 3.0, taxAmount = 20.0,
        product = Product(name = "Overcooked (Team17)", category = "Game", weight = 20.0, price = 40.0,
          creationDate = LocalDateTime.of(LocalDate.of(2021, Month.JANUARY, 1),
            LocalTime.of(0, 0, 0)))))))

    when(orderDataProviderMock.getAllOrders).thenReturn(listOrder)

    val startDate = LocalDateTime.of(LocalDate.of(2021, Month.FEBRUARY, 1), LocalTime.of(0, 0, 0))
    val endDate = LocalDateTime.of(LocalDate.of(2021, Month.JANUARY, 2), LocalTime.of(0, 0, 0))
    val intervalList = List(Interval(startValue = 1, endValue = 3, rawValue = "<3"))

    val result = orderUseCase.reportOldProductsSoldByDate(startDate, endDate, intervalList)

    assert(result equals "Start date must be before the End date")
  }

  "OrderUseCase" should "report some an error when a given interval out of range" in {

    val listOrder = List(Order("Roger Waters", "rogerwaters@mail.com", "England",
      100.00, LocalDateTime.of(LocalDate.of(2020, Month.DECEMBER, 25),
        LocalTime.of(0, 0, 0)), List(Item(cost = 20.0, shippingFee = 3.0, taxAmount = 20.0,
        product = Product(name = "Overcooked (Team17)", category = "Game", weight = 20.0, price = 40.0,
          creationDate = LocalDateTime.of(LocalDate.of(2021, Month.JANUARY, 1),
            LocalTime.of(0, 0, 0)))))))

    when(orderDataProviderMock.getAllOrders).thenReturn(listOrder)

    val startDate = LocalDateTime.of(LocalDate.of(2017, Month.FEBRUARY, 1), LocalTime.of(0, 0, 0))
    val endDate = LocalDateTime.of(LocalDate.of(2021, Month.JANUARY, 2), LocalTime.of(0, 0, 0))
    val intervalList = List(Interval(startValue = 4, endValue = 3, rawValue = "<3"))

    val result = orderUseCase.reportOldProductsSoldByDate(startDate, endDate, intervalList)

    assert(result equals "Interval has incorrect value: 4, 3")
  }

  "OrderUseCase" should "report some an error when a given interval out of range and a wrong range of dates" in {

    val listOrder = List(Order("Roger Waters", "rogerwaters@mail.com", "England",
      100.00, LocalDateTime.of(LocalDate.of(2020, Month.DECEMBER, 25),
        LocalTime.of(0, 0, 0)), List(Item(cost = 20.0, shippingFee = 3.0, taxAmount = 20.0,
        product = Product(name = "Overcooked (Team17)", category = "Game", weight = 20.0, price = 40.0,
          creationDate = LocalDateTime.of(LocalDate.of(2021, Month.JANUARY, 1),
            LocalTime.of(0, 0, 0)))))))

    when(orderDataProviderMock.getAllOrders).thenReturn(listOrder)

    val startDate = LocalDateTime.of(LocalDate.of(2021, Month.FEBRUARY, 1), LocalTime.of(0, 0, 0))
    val endDate = LocalDateTime.of(LocalDate.of(2021, Month.JANUARY, 2), LocalTime.of(0, 0, 0))
    val intervalList = List(Interval(startValue = 4, endValue = 3, rawValue = "4-3"))

    val result = orderUseCase.reportOldProductsSoldByDate(startDate, endDate, intervalList)

    assert(result equals "Start date must be before the End dateInterval has incorrect value: 4, 3")
  }
}
