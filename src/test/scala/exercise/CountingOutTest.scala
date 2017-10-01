package exercise

import org.scalatest._
import CountingOut._

class CountingOutTest extends FlatSpec with Matchers {

  "findSurvivor" should "return the correct survivor when n > 1 and k > 1" in {
    val result = findSurvivor(5, 3)
    result.isRight shouldBe true
    result.right.get shouldBe 4
  }

  it should "return the correct survivor when n and k are equal" in {
    val result = findSurvivor(3, 3)
    result.isRight shouldBe true
    result.right.get shouldBe 2
  }

  it should "return the correct survivor when n=3 and k=2" in {
    val result = findSurvivor(3, 2)
    result.isRight shouldBe true
    result.right.get shouldBe 3
  }

  it should "return the correct survivor when n is a large number and k=2" in {
    val result = findSurvivor(Int.MaxValue, 2)
    result.isRight shouldBe true
    result.right.get shouldBe 2147483647
  }

  it should "return the left with error message when n = 0" in {
    val result = findSurvivor(0, 2)
    result.isLeft shouldBe true
    result.left.get shouldBe "group size (n) must be greater than or equal to 1"
  }

  it should "return the left with error message when k = 0" in {
    val result = findSurvivor(5, 0)
    result.isLeft shouldBe true
    result.left.get shouldBe "step (k) must be greater than or equal to 1"
  }

}
