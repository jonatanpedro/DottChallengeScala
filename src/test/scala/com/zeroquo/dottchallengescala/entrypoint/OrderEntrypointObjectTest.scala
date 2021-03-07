package com.zeroquo.dottchallengescala.entrypoint

import org.scalatest.flatspec.AsyncFlatSpec

class OrderEntrypointObjectTest extends AsyncFlatSpec{

  it should "eventually compute the report passing the parameters" in {

    val futureResult = OrderEntrypoint.reportOlderOrdersByDate(Array("2018-01-01 00:00:00", "2021-01-01 00:00:00", "1-4", "4-8"))

    futureResult map { result => assert(result.length > 0) }
  }

  it should "eventually compute the result even if received an error" in {

    val futureResult = OrderEntrypoint.reportOlderOrdersByDate(Array("2018-01-01 00:00:00"))

    futureResult map { result => assert(result.length > 0) }
  }
}
