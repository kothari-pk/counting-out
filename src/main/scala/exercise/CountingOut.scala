package exercise

import scala.annotation.tailrec
import utils.MathUtils._

object CountingOut {

  def findSurvivor(args: Array[String]): Either[String, Int] =
    for {
      n <- convertToInt(args(0))
      k <- convertToInt(args(1))
      lastManStanding <- findSurvivor(n, k)
    } yield lastManStanding

  /**
   * tail recursive solution
   * @param n number of people in the circle
   * @param k skip
   * @return surviour's location
   */
  def findSurvivor(n: Int, k: Int): Either[String, Int] = {
    if (n < 1) {
      Left("group size (n) must be greater than or equal to 1")
    } else if (k < 1) {
      Left("step (k) must be greater than or equal to 1")
    } else if (n == 1) {
      Right(1)
    } else if (k == 2) {
      Right(getSafePosition(n))
    } else {
      @tailrec
      def t(remaining: Int, result: Int = 1): Int =
        if (remaining == 0) result else t(remaining - 1, (result + k - 1) % (n - remaining + 1) + 1)

      Right(t(n))
    }
  }

  // Special solution when k = 2
  private def getSafePosition(n: Int): Int = {
    val valueOfL = n - Integer.highestOneBit(n)
    2 * valueOfL + 1
  }
}
