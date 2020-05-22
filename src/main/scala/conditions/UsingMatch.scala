package conditions

object UsingMatch {
  def main(args: Array[String]): Unit = {
    val x: Any = "Bananao"

    val s:String = x match {
      case 0 => "it's zero"
      case 10 => "it's 10"
      case x: Int => s"it is not ten or zero, it's $x"
      case _ => "it's something other"
    }

    println(s)
  }

}
