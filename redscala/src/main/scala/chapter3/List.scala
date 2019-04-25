package chapter3

sealed trait List[+A]

case object Nil extends List[Nothing]

case class Cons[+A](head: A, tail: List[A])

/**
  * https://github.com/fpinscala/fpinscala
  */
object List {


  //TODO 这两个函数一个缺少外围的大括号,到底那个对
  //TODO trait中的List的泛型中的+A 代表这个List是协变的
  // 协变(covariant)      :是你能够使用比原始指定的类型的子类
  // 逆变(contravariance) :是你能够使用比原始指定的类型的父类
  // 不变(invariance)     : 你只能使用比原始指定的类型,不能协变和逆变
  // 上界(upper bounds)   :
  // 下界(lower bounds)   :
//  @annotation.tailrec
//  def sum(ints: List[Int]): Int = ints match {
//    case Nil => 0
//    case Cons(x, xs) => x + sum(xs)
//  }
//
//  @annotation.tailrec
//  def sum(ints: List[Int]): Int = {
//    ints match {
//      case Nil => 0
//      case Cons(x, xs) => x + sum(xs)
//    }
//  }
//}

  def product(ds:List[Double]) :Double = {
    ds match {
      case Nil => 1.0
      case Cons(0.0, _) => 0.0
      case Cons(x, xs) => x * product(xs)
    }
  }

  def apply[A](as:A*):List[A] = {
    if (as.isEmpty) Nil
    else Cons(as.head, apply(as.tail: _*))
  }

}

