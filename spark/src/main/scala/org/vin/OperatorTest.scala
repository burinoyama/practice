package org.vin

import org.apache.spark
import org.apache.spark.rdd.RDD
import org.apache.spark.{SparkConf, SparkContext}
import org.apache.spark.sql.SparkSession

object OperatorTest {

  def main(args: Array[String]): Unit = {
    val conf: SparkConf = new SparkConf().setAppName("OperatorTest").setMaster("local[*]")
    val context = new SparkContext(conf)

    val value: RDD[Int] = context.parallelize(1 to 10)

//    val value: RDD[Array[Int]] = value.glom()

    println(value.filter(_ > 9).collect().toStream)

  }


  def my_glom(value:RDD[Int]): Unit = {
      value.glom().foreachPartition(println)
  }
}
