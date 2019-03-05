package org.vin.wordcount

import org.apache.spark.rdd.RDD
import org.apache.spark.{SparkConf, SparkContext}
import org.apache.spark.sql.SparkSession

object WordCount {

  def main(args: Array[String]): Unit = {

    val conf = new SparkConf().setAppName("WORD_COUNT").setMaster("local[*]")

    val sc = new SparkContext(conf)

    val words: RDD[String] = sc.textFile("./spark/src/main/resources/word.txt")

    wordCount2(words)

  }

  def wordCount1(words: RDD[String]): Unit = {
    val ret = words.map(_.split(" ")).map((_, 1)).groupByKey()

    println(ret)
  }

  //TODO 如何将key value 对换位置？
  def wordCount2(words: RDD[String]): Unit = {
//    val unit: RDD[(String, Int)] = words.flatMap(_.split("\n")).map((_, 1)).reduceByKey(_ + _)
//    unit.map(w=>{(w._2,w._1)})

    println(words.flatMap(_.split("\n")).map((_, 1)).reduceByKey(_ + _).map(w => {
      (w._2, w._1)
    }).sortByKey(false).collect())

//    words.flatMap(_.split("\n")).map((_, 1)).reduceByKey(_ + _).map { case (k: String, v: Int) => {
//      (v, k)
//    }

//      words.flatMap(_.split("\n")).map((_, 1)).reduceByKey(_+_).map(u => {
//      (u._2, u._1)
//    })

  }


}
