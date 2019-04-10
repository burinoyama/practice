package org.vin.code

import org.apache.spark.rdd.RDD
import org.apache.spark.{SparkConf, SparkContext}


case class adid(did:String, explo_count:Long, clickCount:Long){}

object Execise {

  private val conf: SparkConf = new SparkConf().setMaster("yarn").setAppName("did")

  private val context = new SparkContext(conf)

  private val text: RDD[String] = context.textFile("hdfs://topics/userAction/click/2016-07-25")

  private val value: RDD[adid] = text.map { line =>
    val lines: Array[String] = line.split("&")
    val did: String = lines(3)

    val dids: Array[String] = did.split("=")
    val didNums = dids(1)
    new adid(dids(0), dids(1))

  }
  value
}
