package org.vin.wordcount

import org.apache.spark.rdd.RDD
import org.apache.spark.{SparkConf, SparkContext}
import org.apache.spark.sql.SparkSession

object WordCount {

  def main(args: Array[String]): Unit = {

    val conf = new SparkConf().setAppName("WORD_COUNT").setMaster("local[*]")

    val sc = new SparkContext(conf)

    val words: RDD[String] = sc.textFile("./spark/src/main/resources/word.txt")

    wordCount1(words)

  }

  def wordCount1(words: RDD[String]): Unit = {
    val ret = words.map((_, 1)).reduceByKey(_+_).collect()

    println(ret)
  }

  def wordCount2(words:RDD[String]): Unit = {

  }


}
