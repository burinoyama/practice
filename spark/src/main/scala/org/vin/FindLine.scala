package org.vin

import org.apache.spark.{SparkConf, SparkContext}

object FindLine {
  def main(args: Array[String]): Unit = {
    val conf = new SparkConf().setAppName("findLine").setMaster("local[*]")

    val context = new SparkContext(conf)

    val file = context.
      textFile("./spark/src/main/resources/research", 5)

    val ret = file.zipWithIndex()

    ret.map(t => (t._2, t._1)).collect.foreach(t => println(t))


  }
}

object FindLineStreaming{
  def main(args: Array[String]): Unit = {

    val conf = new SparkConf().setAppName("findLine").setMaster("local[*]")

    val ssc = new StreamingContext(conf, Seconds(5))

  }
}
