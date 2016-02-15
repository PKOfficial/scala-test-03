package com.knoldus

case class Employee(id:Int,name:String,salary:Double)

object OrderingEmployee extends Ordering[Employee]{
  def compare(x:Employee,y:Employee):Int={
    x.salary.compare(y.salary)
  }
}
