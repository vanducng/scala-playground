package uselist

object ListStuff {

  // Not tail recursive
  def map[T, U](l:List[T]) (op: T => U): List[U] = l match{
    case Nil => Nil
    case h :: t => op(h) :: map(t) (op)
  }

  def processItems[T](l:List[T]) (op: T => Unit): Unit = l match{
    case Nil =>
    case h :: t => op(h) ; processItems(t) (op)
  }

  def main(args: Array[String]): Unit = {
    val names = List("Fred", "Jim", "Sheila")

    println(s"second item in list is ${names(1)}")
    println(s"first item in list is ${names.head}")
    println(s"names is $names")
    println(s"names tail is ${names.tail}")

    val yetMore = "Freddy" :: "Bill" :: "Alan" :: "Susan" :: Nil

    processItems(map(yetMore) (x => x.toUpperCase)) (y => println(s">> $y"))

  }

}
