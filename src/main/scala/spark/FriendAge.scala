package spark

import org.apache.log4j.{Level, Logger}
import org.apache.spark.SparkContext

object FriendAge {
  def parseLine(line: String) = {
    val fields = line.split(",")
    val age = fields(2).toInt
    val numFriend = fields(3).toInt
    (age, numFriend)
  }


  def main(args: Array[String]): Unit = {
    // Set the log level to only print errors
    Logger.getLogger("org").setLevel(Level.ERROR)

    //Spark context
    val sc = new SparkContext("local[*]", "FriendAge")


    val lines = sc.textFile("D:\\tmp\\SparkScala\\fakefriends.csv")
    val rdd = lines.map(parseLine)
    rdd.take(10).map(println)

    println("totalsByAge1------")
    val totalsByAge1 = rdd.mapValues(x => (x, 1))
    totalsByAge1.take(10).map(println)

    println("totalsByAge2------")
    val totalsByAge2 = totalsByAge1.reduceByKey((x, y) => (x._1 + y._1, x._2 + y._2))
    totalsByAge2.take(10).map(println)

    println("averageByAge------")
    val averageByAge = totalsByAge2.mapValues(x => x._1/x._2)
    averageByAge.take(10).map(println)

    println("Result------")
    val result = averageByAge.collect()
    result.sorted.foreach(println)

  }
}
