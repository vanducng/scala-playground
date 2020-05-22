package looping

import scala.annotation.tailrec

object Loops {
//  @tailrec
  def badRecurse(x: Int):Unit = {
    if (x > 0) badRecurse(x - 1) else ()
    println(".")
  }

  @tailrec
  def goodRecurse(x: Int):Unit = {
    println(".")
    if (x > 0) goodRecurse(x - 1) else ()
  }

  @tailrec
  def loopCounter(x: Int): Unit = {
    if (x >= 3)()
    else {
      println(s"x is $x")
      loopCounter(x + 1)
    }

  }
  def main(args: Array[String]): Unit = {
    var x = 0
    while(x < 3){
      println(s"x is ${x}")
      x = x + 1
    }

    loopCounter(0)
//    badRecurse(100000)
    goodRecurse(100000)

    val r = for {
      x <- Range(1, 100) /*1 to 100*/
      if (x%2 == 0)
    } yield x

    println(s"r is $r")

    val tups = for{
      x <- 1 to 3
      y <- 1 to x
      if (y < x)
    } yield (x, y)

    println(s"tups is $tups")
  }
}
