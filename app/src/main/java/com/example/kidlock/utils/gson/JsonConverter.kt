package com.example.kidlock.utils.gson

import com.google.gson.Gson

fun toJsonFromObject(instance: Any): String{
    return Gson().toJson(instance).toString()
}
inline fun <reified Object> fromJsonToObject(json: String): Object{
    val objectInstance =  Gson().fromJson(json, Object::class.java)
    return objectInstance
}