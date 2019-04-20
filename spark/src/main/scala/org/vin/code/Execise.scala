package org.vin.code

import org.apache.spark.rdd.RDD
import org.apache.spark.{SparkConf, SparkContext}


case class adid(did:String, explo_count:Long, clickCount:Long){}

object Execise {

  import java.sql.{Connection, DriverManager, PreparedStatement}

  import org.apache.spark.rdd.{JdbcRDD, RDD}
  import org.apache.spark.{SparkConf, SparkContext}

  object RDD2Mysql {
    def main(args: Array[String]): Unit = {

      //初始化sc
      val conf: SparkConf = new SparkConf().setAppName("WordCount").setMaster("local[*]")
      val sc = new SparkContext(conf)
      sc.setLogLevel("ERROR")


      //读取mysql数据
      //定义连接mysql的参数
      val driver = "com.mysql.jdbc.Driver"
      val url = "jdbc:mysql://192.168.27.62:3306/rdd"
      val userName = "root"
      val passWd = "123456"

      //    val rdd = new JdbcRDD(sc,
      //      () => {
      //        Class.forName(driver)
      //        DriverManager.getConnection(url, userName, passWd)
      //      },
      //      "select id,name from test where id>=? and id<=?",
      //      1,
      //      4,
      //      4,
      //      rs => (rs.getInt(1), rs.getString(2)))
      //
      //
      //    rdd.foreach(println(_))




      //rdd数据输出到mysql
      val rdd: RDD[(Int, String)] = sc.makeRDD(List((5, "xiaomi")))

      rdd.foreachPartition(x => {

        Class.forName(driver)
        val conn: Connection = DriverManager.getConnection(url, userName, passWd)

        x.foreach(x => {
          val id: Int = x._1
          val name: String = x._2

          val ps: PreparedStatement = conn.prepareStatement("insert into test (id,name) values (?,?)")
          ps.setInt(1, id)
          ps.setString(2, name)

          ps.execute()
        })
      })


      sc.stop()

    }

  }
}
