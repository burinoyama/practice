package org.vin.transformation

import org.apache.spark.rdd.RDD
import org.apache.spark.{SparkConf, SparkContext}

object Transformations {


  def main(args: Array[String]): Unit = {

    val conf = new SparkConf().setAppName("WORD_COUNT").setMaster("local[*]")

    val sc = new SparkContext(conf)

   val value: RDD[Int] = sc.parallelize(1 to 1000)

    println(value.countApproxDistinct(0.00018))


  }
}
