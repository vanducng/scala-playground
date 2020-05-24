package test

import basic.DataStructure.shipList

object Test {
  def square(x: Int): Int = {
    x * x
  }

  def cubeIt(x: Int): Int = {
    x * x * x
  }

  def transform(x: Int, f: Int => Int):Int = {
    f(x)
  }

  def main(args: Array[String]): Unit = {
    val r = square(4)
    println(s"r is $r")

    val r2 = cubeIt(3)
    println(s"r2 is $r2")

    val r3 = transform(3, cubeIt)
    println(s"r3 is $r3")

    val r4 = transform(2, x => {val y = x*2; y*y})
    println(s"r4 is $r4")

    val shipList = List("Enterprise", "Defiant", "Voyager", "Deep Space Nine")
    for (ship <- shipList) {println(ship)}

    // Reverse
    val backwardShips = shipList.map((ship: String) => ship.reverse)
    for (ship <- backwardShips) {println(ship)}

    //Reduce
    val numberList = List(1,2,3,4,5)
    val sum = numberList.reduce((x:Int, y:Int) => x + y)
    println(s"Sum of list is $sum")

    //Filter
    val iHateFive = numberList.filter((x:Int) => x != 5)
    println(s"iHaveFive list is $iHateFive")

    val iHaveThree = numberList.filter(_ != 3)
    println(s"iHaveThree list is $iHaveThree")

    val rdd = List(33 -> 385, 33 -> 2, 55 -> 221)
    val totalByAge = rdd.map(x => (x, 1))

    println(s"totalByAge is $totalByAge")

  }

}
