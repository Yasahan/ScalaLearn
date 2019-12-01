package Artikelverwaltung

import scala.collection.mutable.ArrayBuffer

class Database extends StockManagement {

  var storedItems = new Array[StoreItem](1000)
  var storedItemsDynamic = new ArrayBuffer[StoreItem]()

  override def delete(id: Int): Array[StoreItem] = {
    var gefunden = false
    for(i <- storedItemsDynamic.indices) {
      if(storedItemsDynamic(i).getId == id) {
        storedItemsDynamic(i).printAction(" gelöscht", storedItemsDynamic(i).getName)
        storedItemsDynamic.remove(i)
        gefunden = true
      }
    }
    if(!gefunden) storedItemsDynamic(0).printAction(" nicht gefunden", id.toString)
    storedItems = storedItemsDynamic.toArray
    storedItems
  }

  override def search(name: String): Array[StoreItem] = {
    val names = new ArrayBuffer[StoreItem]()
    var gefunden = false
    for(i <- storedItemsDynamic.indices)
      if(storedItemsDynamic(i).getName == name) {
        storedItemsDynamic(i).printAction(" gefunden", storedItemsDynamic(i).getName)
        names.insert(0,storedItemsDynamic(i))
        gefunden = true
      }
    if(!gefunden) storedItemsDynamic(0).printAction(" nicht gefunden", name)

    names.toArray
  }

  override def store(item: StoreItem): Array[StoreItem] = {
    storedItemsDynamic.insert(0, item)
    item.printAction(" gefunden", item.getName)
    storedItems = storedItemsDynamic.toArray
    storedItems
  }

  override def sumUp(): Int = {
    var sum = 0
    for(i <- storedItemsDynamic) {
      sum += i.getValue
    }
    sum
  }



}
