package utils

import org.scalatest._
import MathUtils._

class MathUtilsTest extends FlatSpec with Matchers {
  "convertToInt" should "convert the a valid integer string to int" in {
    val result = convertToInt("10")
    result.isRight shouldBe true
    result.right.get shouldBe 10
  }

  it should "return left for invalid integer string" in {
    val result = convertToInt("hello")
    result.isLeft shouldBe true
  }
}
