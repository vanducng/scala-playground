package conditions


case class Truck(capacity: Int)
case class Car(seat: Int, manual: Boolean)


object Logistics {
  def main(args: Array[String]): Unit = {
//    val thing: Any  = Truck(10)
    val thing: Any  = Car(5, true)
    val maxLoad = thing match {
//      case t: Truck => t.capacity
      case Truck(c) => c
      case Car(s, _) if s > 4 => 170 * (s - 1) // guard condition
      case Car(s, _) => 150 * (s - 1) + 20 //for the truck

    }

    println(s"thing can carry $maxLoad")
  }
}
