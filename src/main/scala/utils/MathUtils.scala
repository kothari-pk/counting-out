package utils

import scala.util.control.Exception.allCatch

object MathUtils {
  def convertToInt(str: String): Either[Throwable, Int] = allCatch.either(str.toInt)
}
