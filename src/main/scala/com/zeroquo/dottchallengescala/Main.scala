package com.zeroquo.dottchallengescala

import com.zeroquo.dottchallengescala.entrypoint._

import scala.concurrent.ExecutionContext.Implicits.global
import scala.concurrent.Future
import scala.util.{Failure, Success}

object Main extends App {

  private val eventualString: Future[String] = OrderEntrypoint.reportOlderOrdersByDate(args)

  eventualString.onComplete{
    case Success(result) => println(result)
    case Failure(except) => except.printStackTrace()
  }

  Thread.sleep(5000)
}
