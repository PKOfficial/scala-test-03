package com.knoldus

import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.scalatest.FunSuite

class OrderingEmployeeTest extends FunSuite{

  val logger:Logger = LoggerFactory.getLogger(this.getClass)

  test("Checking Valid List"){
    val list = List(Employee(1,"PK",23232323),Employee(2,"AS",21312),Employee(3,"TK",2132132))
    val result = list.sorted(OrderingEmployee)
    logger.info("Result " + result)
    assert(result === List(Employee(2,"AS",21312.0), Employee(3,"TK",2132132.0), Employee(1,"PK",2.3232323E7)))
  }

  test("Checking Equal List"){
    val list = List(Employee(1,"PK",23232323),Employee(2,"PK",23232323),Employee(3,"PK",23232323))
    val result = list.sorted(OrderingEmployee)
    logger.info("Result " + result)
    assert(result === List(Employee(1,"PK",23232323),Employee(2,"PK",23232323),Employee(3,"PK",23232323)))
  }

  test("Checking Empty List"){
    val list = List()
    val result = list.sorted(OrderingEmployee)
    logger.info("Result " + result)
    assert(result === List())
  }

}
