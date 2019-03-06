package core

data class ItemData(val id:Int, val jname:String, val ename:String) {
    val name :String
        get() = jname
}