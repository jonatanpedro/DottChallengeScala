package com.zeroquo.dottchallengescala.usecase.entity

import java.time.LocalDateTime

case class Order(customerName: String, contact: String, shippingAddress: String, grandTotal: BigDecimal,
                 orderDate: LocalDateTime, items: List[Item])
