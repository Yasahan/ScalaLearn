package Artikelverwaltung

import scala.collection.mutable.ArrayBuffer

class Database extends StockManagement {

  var storedItems = new ArrayBuffer[StoreItem]()

  override def delete(id: Int): Array[StoreItem] = {
    var gefunden = false
    for(i <- storedItems.indices) {
      if(storedItems(i).getId == id) {
        storedItems(i).printAction(" gelöscht", storedItems(i).getName)
        storedItems.remove(i)
        gefunden = true
      }
    }
    if(!gefunden) storedItems(0).printAction(" nicht gefunden", id.toString)
    storedItems.toArray

  }

  override def search(name: String): Array[StoreItem] = {
    val names = new ArrayBuffer[StoreItem]()
    var gefunden = false
    for(i <- storedItems.indices)
      if(storedItems(i).getName == name) {
        storedItems(i).printAction(" gefunden", storedItems(i).getName)
        names.insert(0,storedItems(i))
        gefunden = true
      }
    if(!gefunden) storedItems(0).printAction(" nicht gefunden", name)

    names.toArray
  }

  override def store(item: StoreItem): Array[StoreItem] = {
    storedItems.insert(0, item)
    item.printAction(" gespeichert", item.getName)
    storedItems.toArray
  }

  override def sumUp(): Int = {
    var sum = 0
    for(i <- storedItems) {
      sum += i.getValue
    }
    sum
  }



}
