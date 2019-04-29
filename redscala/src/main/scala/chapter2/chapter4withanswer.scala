package chapter2

class chapter4withanswer {


}

object MyModule {

  def abs(n: Int) = {
    if (n < 0) -n
    else n
  }

  private def formatAbs(x: Int) = {
    val msg = "The absolute value of %d is %d"
    msg.format(x, abs(x))
  }


  def main(args: Array[String]): Unit = {
    println(formatAbs(-42))
    println(factorail(4))
    println(factorial2(4))
  }

  // A definition of factorial, using a local, tail recursive function
  def factorail(n: Int) = {
    @annotation.tailrec
    def go(n: Int, acc: Int): Int = {
      if (n <= 0) acc
      else go(n - 1, n * acc)
    }

    go(n, 1)
  }

  // Another implements of `factorial`, this time with a  `while` loop
  def factorial2(n: Int) = {
    var acc = 1
    var i = n
    while (i > 0) {
      acc *= i
      i -= 1
    }
    acc
  }

  //Exercise 1 : Write a function to compute the nth fibonacci number
  def fib(n: Int): Int = {
    if (n == 1) 0
    else if (n == 2) 1
    else fib(n - 1) * fib(n - 2)
  }

  private def formatFactorial(n: Int) = {
    val msg = "The factorial of %d is %d"
    msg.format(n, factorail(n))
  }

  def formatResult(name: String, n: Int, f: Int => Int) = {
    val msg = "The %s of %d is %d"
    msg.format(name, n, f(n))
  }
}


object FormatAbsAndFactorial {

  import MyModule._

  // Now we can use your general `formatResult` function
  // With both `abs` and `factorial`
  def main(args: Array[String]): Unit = {
    println(formatResult("absolute value", -4, abs))
    println(formatResult("factorial", 9, factorail))
  }
}

object AnonymousFunctions {

  import MyModule._

  def main(args: Array[String]): Unit = {
    println(formatResult("absolute value", -42, abs))
    println(formatResult("factorial", 7, factorail))
    println(formatResult("increment1", 7, (x: Int) => x + 1))
    println(formatResult("increment", 7, (x) => x + 1))
    println(formatResult("increment3", 7, x => x + 1))
    println(formatResult("increment4", 7, _ + 1))
    println(formatResult("increment5", 7, x => {val r = x + 1; r}))
    println(formatResult("absolute value", -7, x => {if (x < 0) -x; else x}))
  }
}

/**
  * First, a binary search implementation, specialized to `Double`,
  * another primitive type in Scala, representing 64-bit floating
  * point numbers
  * Ideally, we could generalize this to work for any `Array` type,
  * so long as we have some way of comparing elements of this `array`
  */
object MonomorphicBinarySearch {

  def binarySearch(ds:Array[Double], key:Double) :Int = {
    @annotation.tailrec
    def go(low:Int, mid:Int, high:Int):Int = {
      if (low > high) -mid - 1
      else {
        val mid2 = (low + high) / 2
        val d = ds(mid2)
        if (d == key) mid2
        else if (d > key) go(low, mid2, mid2 - 1)
        else go(mid2 + 1, mid2, high)
      }
    }
    go(low = 0, mid = 0, ds.length - 1)

  }
}


/**
  * Here's a polymorphic version of `binarySearch`, parameterized on
  * a function for testing whether an `A` is greater than another `A`.
  */

object PolymorphicFunctions {

  def binarySearch[A](as:Array[A], key:A, gt:(A,A) => Boolean) : Int = {
    @annotation.tailrec
    def find(low:Int, mid:Int, high:Int):Int = {
      if(low > high) -mid - 1
      else {
        val mid2 = low + (high - low) / 2
        val ele = as(mid2)
        val greater = gt(ele, key)
        if (!greater && !gt(key, ele)) mid2
        else if (greater) find(low, mid2, mid2 - 1)
        else find(mid2 + 1, mid2, high)
      }
    }
    find(0, 0, as.length - 1)
  }

  def binarySearch2[A](as:Array[A], key:A, gt:(A,A) => Boolean):Int = {
    @annotation.tailrec
    def find(lo:Int, hi:Int):Int = {
      if (lo > hi) return -1
      else {
        val mid2 = lo + (hi - lo) / 2
        val ele = as(mid2)
        val greater = gt(ele, key)
        if (!greater && !gt(key, ele)) mid2
        else if (greater) find(lo, mid2 - 1)
        else find(mid2 + 1 , hi)
      }
    }
    find(0, as.length - 1)
  }

  // Exercise 2:Implement a polymorphic function to check whether
  // an `Array[A]` is sorted
  //TODO 这个方法中return false 怎么才能不用return 关键字就能保证跳出循环
  def isSorted[A](as:Array[A], gt:(A,A) => Boolean):Boolean ={
    for (index <- 1 until as.length) {
      val prev = as.head
      val next = as.tail.head
      if (gt(prev, next)) return false
    }
    true
  }

  // Polymorphic functions are often so constrained by their type
  // that they only have one implementation! Here's an example
  def partial1[A, B, C](a:A, f:(A,B) =>C) : B => C = {
    (b: B) => f(a, b)
  }

  // NOte that `=>` associate to the right, so we could
  // write the return type as `A => B => C`
  //TODO 怎么做
  def curry[A, B, C](f:(A,B) => C):A => (B => C) = ???
//    (a:A) = f(a)

//  def curry2[A, B, C](f:(A, B) => C):A => (B => C) = {
//    def currySeperate(a:A)(b:B) :B => C ={
//      f(a)(b)
//    }
//  }

  //Exercise 4: Implement `uncurry`
  //TODO
  def uncurry[A, B, C](f:A => B => C):(A, B) => C = ???

  //Exercise 5:Implement `compose
  def compose1[A, B, C](f:B => C, g:A => B):A => C = (a:A) => f(g(a))

  def compose2[A, B, C](f:B => C, g:A => B):A => C = f.compose(g)

  def compose3[A, B, C](f:B => C, g:A => B):A => C = g.andThen(f)


}

object searchTest {
  import PolymorphicFunctions._
  def main(args: Array[String]): Unit = {
//    val ds = Array(2.0,5,7,9,11)
//    println(bsearch(ds, 11.toDouble))
//    println(binarySearch(ds, 11.toDouble, (x: Double, y: Double) => x > y))
//    println(binarySearch2(ds, 2.toDouble, (x: Double, y: Double) => x > y))
    println(compose2((x: Int) => x + 1, (y: Int) => y * 2).apply(5))


  }
}