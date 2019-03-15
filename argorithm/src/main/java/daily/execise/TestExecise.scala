package daily.execise

import scala.util.Random

object TestExecise {
  def main(args: Array[String]): Unit = {


    while (true) {
      println(getCoinFace())
    }

  }

  def getCoinFace()= {
    new Random().nextInt(2)
  }
}
