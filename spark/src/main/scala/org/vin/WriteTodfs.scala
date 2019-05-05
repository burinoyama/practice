package org.vin

import org.apache.spark.rdd.RDD
import org.apache.spark.{SparkConf, SparkContext}

object WriteTodfs {


  private var count:Int = _
  def main(args: Array[String]): Unit = {

    val path = "hdfs://192.168.159.105:9000"

    val conf: SparkConf = new SparkConf().setAppName("write").setMaster("local[*]")


    val sc = new SparkContext(conf)


    val rdd: RDD[String] = sc.textFile(path + "/student/little", 1)

//    val ret: RDD[(Long, String)] = rdd.zipWithIndex().map { t =>
//      (t._2 + 1, t._1)
//    }
//    ret.saveAsTextFile(path + "/student/ret/ret")

    rdd.zipWithIndex().map(t => (t._2 + 1, t._1)).saveAsTextFile(path + "/student/ret/")

  }

}
