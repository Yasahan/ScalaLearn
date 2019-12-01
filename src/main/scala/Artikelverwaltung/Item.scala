package Artikelverwaltung

class Item (id :Int, name: String, value:Int) extends Printer {

  def getId: Int = id
  def getName: String = name
  def getValue: Int = value

  def printAction(id:Int, name:String, value:Int): Unit ={
    println(name + " wurde gespeichert!")
  }
}

trait Printer {
  def printAction (actionName: String, name: String): Unit = { }
}
