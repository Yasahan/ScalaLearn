package Test

import scala.collection.mutable.ArrayBuffer

object TestObj {


  def main(args: Array[String]) = {

    var x = 1001
    var y = 200

    println(x+y)

    var greaterThan3000 = if(x+y > 3000) "ja" else "nein"

    if(x+10 == 1011){
      println(true)
    }
    else if(y+2 == 50){
      println(false)
    }

    var  randLetters = "ABCDEFGHKLMNOPRSYTUVYZ"

    for(i <- 0 until randLetters.length){
      println(randLetters(i))
    }

    var newList = List(1,2,3,4,5,7,7,9,0)

    for(i <- newList){
      println(i)
    }


    var str = "15"
    var inge = 22

    println(inge + str.toInt)



    def sum(x:Int, y:Int) : Int =
      {
        return x+y
      }

      println("5 + 7 = " +  sum(5,7))

    def sum2(args: Int*) : Int =
      {
        var sum = 0
        for(i <- args){
          sum+=i
        }
        return sum
      }

    println(sum2(1,5,7,9))
    val queen = ArrayBuffer[String]("Freddie", "John", "Roger", "Brian")
    val numbers = ArrayBuffer[Int](3,3467,2,234,56754,1,1,3,7,78,4,213,4,4)

    println("Min: " + numbers.min)
    println("Max: " + numbers.max)
    queen += "Bob"

    for(i <- queen)
      println(i)

  } // End of Main


}
