package com.zeroquo.dottchallengescala.usecase.entity

case class Interval(startValue: Int = 0, endValue: Int = 0, comparator: String = "", edgeValue: Int = 0,
                    rawValue: String = "", isRangeType: Boolean = true){
  def isComparatorLessThan : Boolean = "<".equals(comparator)
  def isComparatorGreaterThan : Boolean = ">".equals(comparator)
}
