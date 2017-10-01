package utils

import scala.util.Try

object Helpers {

  type Error = String

  implicit class StrToInt(str: String) {
    def convertToInt: Either[Error, Int] = Try(str.toInt).toEither.left.map(_.getMessage)
  }
}
