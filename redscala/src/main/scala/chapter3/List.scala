package chapter3

import scala.collection.mutable.ListBuffer

sealed trait List[+A]

case object Nil extends List[Nothing]

case class Cons[+A](head: A, tail: List[A]) extends List[A]

object List {

  def sum(ints: List[Int]): Int = ints match {
    case Nil => 0
    case Cons(h, t) => h + sum(t)
  }

  def product(ds: List[Double]): Double = ds match {
    case Nil => 1.0
    case Cons(0.0, _) => 0.0
    case Cons(h, t) => h * product(t)
  }

  def apply[A](as: A*): List[A] =
    if (as.isEmpty) Nil
    else Cons(as.head, apply(as.tail: _*))
}

object ListTest {
  import List._
  def main(args: Array[String]): Unit = {
//    val list = List(1, 3, 5)
//    println(sum(list))
////    println(ListBuffer[Int](1, 2, 3).toArray(Array.ofDim[Int](3)))
//    import scala.collection.JavaConverters._
//    val ints = ListBuffer[Int](1, 2, 3)
//    ints.asJava.toArray().foreach(t => println(t))
//    ints.toArray

    println(add(3)(4))
  }

//  def add(x:Int):(Int => Int) = {
//    (y:Int) => {
//      x + y
//    }
//  }

  def add(x:Int)(y:Int): Int = x + y
}

