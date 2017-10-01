package utils

import org.scalatest._
import Helpers._

class HelpersTest extends FlatSpec with Matchers {
  "convertToInt" should "convert the a valid integer string to int" in {
    val result = "10".convertToInt
    result.isRight shouldBe true
    result.right.get shouldBe 10
  }

  it should "return left for invalid integer string" in {
    val result = "hello".convertToInt
    result.isLeft shouldBe true
    result.left.get shouldBe """For input string: "hello""""
  }
}
