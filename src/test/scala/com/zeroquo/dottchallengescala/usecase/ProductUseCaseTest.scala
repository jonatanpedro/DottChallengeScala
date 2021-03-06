package com.zeroquo.dottchallengescala.usecase

import org.scalatest.flatspec.AnyFlatSpec

class ProductUseCaseTest extends AnyFlatSpec {

  "test" must "print Hello" in {

    val useCase = new ProductUseCase
    val str = useCase.test("Any String")

    assert("Hello" equals str)
  }

}
