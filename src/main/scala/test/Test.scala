package test

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


  }

}
