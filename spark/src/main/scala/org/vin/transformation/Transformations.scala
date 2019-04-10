package org.vin.transformation

import org.apache.spark.rdd.RDD
import org.apache.spark.{SparkConf, SparkContext}

import scala.reflect.ClassTag

object Transformations {


  def main(args: Array[String]): Unit = {

    val conf = new SparkConf().setAppName("WORD_COUNT").setMaster("local[*]")

    val sc = new SparkContext(conf)



    val value: RDD[Int] = sc.makeRDD(1 to 3, 3)

//    println(value.countApproxDistinct(0.00018))


    val i: Int = value.aggregate(1)(_+_, _+_)

    print(i)

    def test[T:Manifest](ary:T*):Array[T] = {
      val ts = new Array[T](ary.length)
      ts
    }


  }
}
