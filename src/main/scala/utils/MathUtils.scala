package utils

import scala.util.{Failure, Success, Try}

object MathUtils {
  def convertToInt(str: String): Either[String, Int] = Try(str.toInt) match {
    case Success(value) => Right(value)
    case Failure(e) => Left(e.getMessage)
  }
}
