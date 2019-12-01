package Artikelverwaltung

class Item (id :Int, name: String, value:Int) extends Printer {

  def getId: Int = id
  def getName: String = name
  def getValue: Int = value

  override def printAction(actionName: String, name: String): Unit ={
    println(name + actionName)
  }
}


