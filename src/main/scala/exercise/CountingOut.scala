package exercise

import scala.annotation.tailrec
import utils.Helpers._

object CountingOut {

  def findSurvivor(args: Array[String]): Either[Error, Int] =
    for {
      n <- args(0).convertToInt
      k <- args(1).convertToInt
      lastManStanding <- findSurvivor(n, k)
    } yield lastManStanding

  /**
   * tail recursive solution
   * @param n number of people in the circle
   * @param k skip
   * @return survivor's location
   */
  def findSurvivor(n: Int, k: Int): Either[Error, Int] = {
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
