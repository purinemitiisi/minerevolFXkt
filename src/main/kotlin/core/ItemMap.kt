package core

import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper
import com.fasterxml.jackson.module.kotlin.readValue

class ItemMap : HashMap<String, Item>() {
    //todo:Int-> (Int,boolean) boolean is visible

    fun add(item:Item) {
        val it = this[item.name] ?: return
        it += item.num
    }

    fun contains(item:Item) : Boolean{
        if (item.num < this[item.name]?.num ?: 0) return true
        return false
    }

    fun load(){
        val json = ClassLoader.getSystemResource("ItemData.json")
        val mapper = jacksonObjectMapper()
        val itemDataList = mapper.readValue<List<ItemData>>(json)
        for (itemData in itemDataList) {
            this[itemData.ename] = Item(itemData.ename,0)
        }
    }
}