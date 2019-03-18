package org.vin.wordcount

import org.apache.spark.rdd.RDD
import org.apache.spark.{SparkConf, SparkContext}
import org.apache.spark.sql.SparkSession

object WordCount {

  val SEP = "\n"

  def main(args: Array[String]): Unit = {

    val conf = new SparkConf().setAppName("WORD_COUNT").setMaster("local[*]")

    val sc = new SparkContext(conf)

    val words: RDD[String] = sc.textFile("./spark/src/main/resources/word")

    wc6(words)

  }


  def wc6(words: RDD[String]): Unit = {
//    words.flatMap(_.split(SEP)).map((_, 1)).combineByKey(x => x, (x: Int, y: Int) => x + y, (x: Int, y: Int) => x + y).collect.foreach(println)
    words.flatMap(_.split(SEP)).map((_, 1)).combineByKey(_, _, _).collect.foreach(println)
  }

  def wc5(words: RDD[String]): Unit = {
    words.flatMap(_.split(SEP)).map((_, 1)).aggregateByKey(0)(_ + _, _ + _).foreach(println)
  }

  def wc4(words: RDD[String]): Unit = {
    //    val unit: RDD[String] = words.flatMap(_.split("\n"))
    words.flatMap(_.split(SEP)).groupBy(x => x).map(t => (t._1, t._2.toList.size)).collect().foreach(println)
  }

  def wc3(words: RDD[String]): Unit = {
    words.flatMap(_.split(SEP)).map((_, 1)).foldByKey(0)(_ + _).collect().foreach(println)
  }

  def wc2(words: RDD[String]): Unit = {
    words.flatMap(_.split(SEP)).countByValue().foreach(println)
  }

  def wc1(words: RDD[String]): Unit = {
    words.flatMap(_.split(SEP)).map((_, 1)).reduceByKey(_ + _).collect().foreach(println)
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
