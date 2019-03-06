package core

data class Item(val name:String, var num:Int) {
    val data
    operator fun plus(n : Int) = Item(name, n+num)
    operator fun plusAssign(n : Int) {num += n}
}