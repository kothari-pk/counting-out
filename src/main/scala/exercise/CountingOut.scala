package exercise

import scala.annotation.tailrec

object CountingOut {
  /**
    * tail recursive solution
    * @param n number of people in the circle
    * @param k skip
    * @return surviour's location
    */
  def findSurvivor(n: Int, k: Int): Either[String, Int] = {
    if (n < 1) {
      Left("group size (n) must be greater than or equal to 1")
    }
    else if(k < 1) {
      Left("step (k) must be greater than or equal to 1")
    }
    else if (n == 1) {
      Right(1)
    }
    else {
      @tailrec
      def t(remaining: Int, result: Int = 1): Int =
        if (remaining == 0) result else t(remaining - 1, (result + k - 1) % (n - remaining + 1) + 1)

      Right(t(n))
    }
  }
}
