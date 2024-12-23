package com.example.kidlock.utils.mapper

import kotlin.reflect.KMutableProperty1
import kotlin.reflect.full.findParameterByName
import kotlin.reflect.full.memberProperties


//source is object need mapping
//target is object target
// mapping is  name property of source mapping to property of target
fun  mapping(source: Any, mapping: Map<String, String>, objectTarget: Any, formatCallBack: List<()->Unit> = listOf()): Any{
    //val objectTarget = (ObjectTarget::class.memberExtensionProperties.find { it.name == mapping.get("") }!! as KMutableProperty1<*, *>).set()
   // val memberProperty = objectTarget!!::class.java
   // val listPropertyTarget = objectTarget::class.constructors.first().x`
    val propertyOfSource = source::class.members
    val propertyOfObjectTarget = objectTarget::class.members
    for(execute:()->Unit in formatCallBack){
        run { execute() }
    }
    for (properties in mapping){
        val propertyOfResource = (propertyOfSource.find { it.name == properties.key } as KMutableProperty1<Any, Any>).get(source!!)
        (propertyOfObjectTarget!!.find {
            it.name == properties.value
        } as KMutableProperty1<Any, Any>).set(objectTarget!!, propertyOfResource!!)
    }
    return  objectTarget

}



data class Source(
    var name : String= "Quan",
    var test: String= "Sy"
)

data class Target(
    var like: String = "",
    var test: String = ""
)
