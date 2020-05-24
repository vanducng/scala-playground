package spark

import org.apache.log4j.{Level, Logger}
import org.apache.spark.SparkContext

object MinTemperature {
  def parseLine(line:String) = {
    val fields = line.split(",")
    val stationID = fields(0)
    val entryType = fields(2)
    val temperature = fields(3).toFloat*0.1f*(9.0f/5.0f) + 32.0f
    (stationID, stationID, entryType, temperature)
  }

  def main(args: Array[String]): Unit = {
    // Set the log level to only print errors
    Logger.getLogger("org").setLevel(Level.ERROR)

    val sc = new SparkContext("local[*]", "MinTemperature")

    val lines = sc.textFile("D:\\tmp\\SparkScala\\1800.csv")
    val parsedLines = lines.map(parseLine)

    parsedLines.take(10).map(println)


    val minTemps = parsedLines.filter(x => x._2 == "TMIN")
    minTemps.take(10).map(println)

  }
}
