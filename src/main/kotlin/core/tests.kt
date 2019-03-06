package core

import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper
import com.fasterxml.jackson.module.kotlin.readValue
import com.sun.prism.shader.FillEllipse_RadialGradient_REPEAT_AlphaTest_Loader
import java.io.File

fun main(args: Array<String>) {
    val itemJson = ClassLoader.getSystemResource("ItemData.json").readText()
    val mapper = jacksonObjectMapper()
    val itemData = mapper.readValue<List<ItemData>>(itemJson)
    println(itemData[0])
    println(itemData[1])
    val itemMap = ItemMap()
    itemMap.load()
    println(itemMap)

    val recipeJson = ClassLoader.getSystemResource("ItemRecipe.json").readText()
    val recipe = mapper.readValue<List<CraftRecipe>>(recipeJson)
    println(recipe[0])
    println(recipe[1])

}