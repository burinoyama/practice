object chapter2 {
  def main(args: Array[String]): Unit = {

    val words = Array("mono", "dioxide", "fudge", "strata")
    val ints = Array(1, 2, 5, 7, 3)

    //    println(isSorted(ints, (a: Int, b: Int) => a < b))

//    println(partial_test(1, (x: Int, y: Int) => x + y).apply(3))


    println(test((x: Int) => x + 1, (y: Int) => y * 2).apply(2))

  }

  def test[A, B, C](f:B => C, g: A => B) = {
    (a:A) => f(g(a))
  }


  // 习题2.3  TODO  不太明白这个题的意思
  //  def curry[A, B, C](f:(A, B) => C):A => (B => C)


  //习题2.4 TOOD 反柯里化
  //  def uncurry[A, B, C](f:A => B => C):(A, B) => C

  //习题2.5 将两个函数合成为一个函数
//  def compose[A, B, C](f: B => C, g: A => B): A => C
  def compose[A, B, C](f: B => C, g: A => B) = {
//  f.compose(g)
}







  //柯里化测试，输入一个参数和一个函数，返回一个仍然需要一个参数的函数
  def partial_test[A, B, C](a: A, f: (A, B) => C) = {
    (b: B) => f(a, b)
  }


  // TODO 在这个ordered的判断方法中，怎么样才能不用return，现在的情况是不用return就不中断之后的判断 master left
  def isSorted[A](ss: Array[A], ordered: (A, A) => Boolean): Boolean = {
    var tmp = ss
    for (i <- 0 until ss.length - 1) {
      println(ordered(tmp.head, tmp.tail.head))
      println("compare the two element : " + tmp.head + " " + tmp.tail.head)
      if (!ordered(tmp.head, tmp.tail.head)) return false
      tmp = tmp.tail
    }
    true
  }

  def findFirstEternal[A](ss: Array[A], p: A => Boolean): Int = {
    @annotation.tailrec
    def loop(n: Int): Int = {
      if (n > ss.length - 1) -1
      else if (p(ss(n))) n
      else loop(n + 1)
    }

    loop(0)

  }


  def findFirstGeneric[A](ss: Array[A], key: A): Int = {
    @annotation.tailrec
    def loop(n: Int): Int = {
      if (n > ss.length - 1) -1
      else if (ss(n) == key) n
      else loop(n + 1)
    }

    loop(0)
  }


  def findFirst(ss: Array[String], key: String): Int = {
    @annotation.tailrec
    def loop(n: Int): Int = {
      if (n > ss.length - 1) -1
      else if (ss(n) == key) n
      else loop(n + 1)
    }

    loop(0)
  }
}
