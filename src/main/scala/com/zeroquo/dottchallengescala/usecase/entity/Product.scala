package com.zeroquo.dottchallengescala.usecase.entity

import java.time.LocalDateTime

case class Product(name: String, category: String, weight: BigDecimal, price: BigDecimal, creationDate: LocalDateTime)
