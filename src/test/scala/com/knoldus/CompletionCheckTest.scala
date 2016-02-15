package com.knoldus

import org.scalatest.FunSuite
import scala.concurrent.{Future, Await}
import scala.concurrent.duration._
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import scala.concurrent.ExecutionContext.Implicits.global


/**
  * Created by prabhat on 15/2/16.
  */
class CompletionCheckTest extends FunSuite{

  val logger:Logger = LoggerFactory.getLogger(this.getClass)

  val checkFuture = new CompletionCheck

  val f1 = Future{Thread.sleep(1000);1}
  val f2 = Future{Thread.sleep(2000);2}

  test("Check First"){

    val result = checkFuture.findFirst(List(f1,f2))
    val finalResult = Await.result(result,10 second)
    val checkResult = Await.result(f1,10 second)
    logger.info("Completed Factorial of Future is: " + finalResult)
    assert(finalResult == checkResult)
  }

}

