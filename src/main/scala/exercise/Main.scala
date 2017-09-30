package exercise

import utils.MathUtils._
import CountingOut._

object Main extends App {
  if (args.length != 2) kill("Missing exactly 2 arguments!")

  val result = for {
    n <- convertToInt(args(0))
    k <- convertToInt(args(1))
    res <- findSurvivor(n, k)
  } yield res

  result match {
    case Right(lastManStanding) => println(s"Survivor is $lastManStanding")
    case Left(e)       => kill(e)
  }

  /**
   * Kill the app and print `msg` provided to std error.
   *
   * @param msg       Description of why application died.
   * @param exitCode  Will be the return code emitted on application death. Defaults to 1.
   * @param showUsage Decides whether to show app usage on death. Defaults to true
   */
  def kill(msg: String, exitCode: Int = 1, showUsage: Boolean = true): Unit = {
    Console.err.println(s"Application died with error: $msg")
    if (showUsage) {
      Console.err.println("""
          | Usage: sbt "run n k"
          | Where:
          | n - circle size
          | k - step rate
          | Ex: sbt "run 10 3"
        """.stripMargin)
    }
    System.exit(exitCode)
  }
}
