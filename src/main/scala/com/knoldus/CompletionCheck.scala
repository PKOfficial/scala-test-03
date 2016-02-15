package com.knoldus

import scala.concurrent.{Promise, Future}
import scala.concurrent.ExecutionContext.Implicits.global

class CompletionCheck{

  def findFirst(list:List[Future[Int]]):Future[Int]= {
    val promise = Promise[Int]
    val future = promise.future
    list foreach {
      _ onComplete  {
        case a =>
          try {
            promise.complete(a)
          }catch {
            case e:java.lang.IllegalStateException =>
          }
      }
    }
    future
  }

}
