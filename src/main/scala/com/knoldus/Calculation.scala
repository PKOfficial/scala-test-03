package com.knoldus

class Calculation {

  private def isAllDigits(x: String) = x forall Character.isDigit

  def calculate(expr:Array[String]):Int= {
    val digitStack = scala.collection.mutable.Stack[String]()
    val operatorStack = scala.collection.mutable.Stack[String]()
    for (i <- expr.indices) {
      if (isAllDigits(expr(i))) {
        digitStack.push(expr(i))
      }
      else {
        if (operatorStack.nonEmpty) {
          if (checkPrecedence(expr(i)) <= checkPrecedence(operatorStack.top)) {
            val sign = operatorStack.pop
            val opr1 = digitStack.pop
            val opr2 = digitStack.pop
            operatorStack.push(expr(i))
            digitStack.push(result(opr1.toInt, opr2.toInt, sign))
          }
          else {
            operatorStack.push(expr(i))
          }
        }
        else {
          operatorStack.push(expr(i))
        }
      }
    }

    while(operatorStack.nonEmpty) {
      val sign = operatorStack.pop
      val opr1 = digitStack.pop
      val opr2 = digitStack.pop
      digitStack.push(result(opr1.toInt, opr2.toInt, sign))
    }

    digitStack.pop.toInt
  }


  def checkPrecedence(toCheck:String):Int={
    toCheck match{
      case "+" => 0
      case "-" => 0
      case "*" => 1
      case "/" => 2
    }
  }

  def result(opr1:Int,opr2:Int,expr:String):String={
    expr match{
      case "+" => (opr2 + opr1).toString
      case "-" => (opr2 - opr1).toString
      case "*" => (opr2 * opr1).toString
      case "/" => (opr2 / opr1).toString
    }
  }

}
