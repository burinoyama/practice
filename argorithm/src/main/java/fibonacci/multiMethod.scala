package fibonacci

object  multiMethod {

  def main(args: Array[String]): Unit = {
    println(fibSeq(6))
  }


  def fib_low_efficient(n:Int) :Int = {
    if (n == 1) 0
    else if (n == 2) 1
    else fib_low_efficient(n - 1) * fib_low_efficient(n - 2)
  }

  def fib_with_array(n:Int):List[Int] = {

    val arr = scala.collection.mutable.ListBuffer[Int](1,2)
    while (arr(arr.length - 1) < n) {
      val tmp = arr(arr.length - 1) + arr(arr.length - 2)
      if (tmp >= n) {
        return arr.toList
      }
      arr += tmp
    }
    arr.toList
  }

  def fibSeq(n: Int): List[Int] = {
    var ret = scala.collection.mutable.ListBuffer[Int](1, 2)
    while (ret(ret.length - 1) < n) {
      val temp = ret(ret.length - 1) + ret(ret.length - 2)
      if (temp >= n) {
        return ret.toList
      }
      ret += temp
    }
    ret.toList
  }



}
