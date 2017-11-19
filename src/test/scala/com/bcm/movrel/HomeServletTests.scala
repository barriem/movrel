package com.bcm.movrel

import org.scalatra.test.scalatest._
import org.scalatest.FunSuiteLike

class HomeServletTests extends ScalatraSuite with FunSuiteLike {

  addServlet(classOf[HomeServlet], "/*")

  test("GET / on HomeServlet should return status 200"){
    get("/"){
      status should equal (200)
    }
  }

}
