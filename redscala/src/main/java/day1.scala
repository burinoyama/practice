import scala.annotation.tailrec

object day1 {

  def main(args: Array[String]): Unit = {
    val ints = List.fill(3)(5)
    //    println(factorial(4))
    //    println(fibonacci(4))

//    (1 to 28).foldLeft("0,1")((a, b) => a + "," + a.split(",").takeRight(2).map(_.toInt).reduceLeft(_ + _))

    println((1 to 28).foldLeft(List(1, 0))((a, b) => (a.head + a.tail.head) :: a).reverse.mkString(","))


    println((1 to 28).foldLeft(List(1, 0))((a, b) => (a.head + a.tail.head) :: a))
    //    println(str.takeRight(2))

//      .takeRight(2)


//      .map(_.toInt).reduceLeft(_ + _))



  }

  def factorial(n: Int): Int = {
    @tailrec
    def go(n: Int, acc: Int): Int = {
      if (n <= 0) acc
      else go(n - 1, acc * n)
    }

    go(n, 1)
  }


  def fib(n: Int): Int = {
    var first = 0
    var second = 1
    if (n == 0) first
    else if (n == 1 || n == 2) second
    else {
      var times = n
      while (times > 1) {
        first = second
        second = second + first
        times = times - 1
      }
      second
    }
  }


  def fibonacci(n: Int) {
    val a0 = 0 //设数列第0个为常量0
    val a1 = 1 //设数列第1个为常量1
    var f0 = a0 //常量赋值给变量初始值
    var f1 = a1 //常量赋值给变量初始值
    var fn = f0 + f1 //设数列第n个为变量，值为前两项之和,n>=2
    for (i <- 2 to n) {
      fn = f0 + f1
      print2double(i, fn)
      f0 = f1
      f1 = fn
    }
  }

  def print2double(i: Int, value: Int) = {
    if (value % 2 == 0) println("n=", i, "value=", value)
  }


}
