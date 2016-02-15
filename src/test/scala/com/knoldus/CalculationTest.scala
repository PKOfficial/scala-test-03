package com.knoldus

import org.scalatest.FunSuite
import org.slf4j.{LoggerFactory, Logger}

class CalculationTest extends FunSuite{

  val calc = new Calculation
  val logger:Logger = LoggerFactory.getLogger(this.getClass)
  test("Check Expression: 1+3*6+3/3"){
    val array = Array("1","+","3","*","6","+","3","/","3")
    val result = calc.calculate(array)
    logger.info("Result is: " + result)
    assert(20 === result)
  }

  test("Check another complex expression: 1*3*6+3/3+4/2"){
    val array = Array("1","*","3","*","6","+","3","/","3","+","4","/","2")
    val result = calc.calculate(array)
    logger.info("Result is: " + result)
    assert(21 === result)
  }

  test("Check expression with MATH ERROR: 1/0"){
    intercept[java.lang.ArithmeticException] {
      val array = Array("1", "/", "0")
      val result = calc.calculate(array)
      logger.info("Result is: " + result)
      assert(21 === result)
    }
  }

  test("Check Invalid Expression: (a+b)"){
    intercept[MatchError] {
      val array = Array("a", "+", "b")
      val result = calc.calculate(array)
      logger.info("Result is: " + result)
    }
  }

}
