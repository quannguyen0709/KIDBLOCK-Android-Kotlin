package com.example.kidlock.utils.resource

import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

suspend fun <T> executeAsynchronous(callBack: suspend ()->Unit, message: String, data: T?= null, dispatcher: CoroutineDispatcher = Dispatchers.IO): Resource<T> {
    val coroutineExceptionHandler = CoroutineExceptionHandler{_, throwable ->
        throwable.message
    }
    var result: Resource<T> = Resource.Error<T>()

    GlobalScope.launch(dispatcher) {
        try {
            callBack()
            result = Resource.Success<T>(message = "EXECUTE SUCCESS ${message}", data = data)

        }catch (ex : RuntimeException){
            result =  Resource.Error<T>(message = "ERROR because ${ex.message} by ${ex.stackTrace} when EXECUTE ${message}", data = data)
        }
    }.join()
    return result
}

fun <T> executeSynchronized( callBack: ()-> Unit, message: String, data: T?): Resource<T>{
    try {
        callBack
        return Resource.Success<T>(message = "EXECUTE SUCCESS ${message}", data = data)
    }catch (ex : Exception){
        return Resource.Error<T>(message = "ERROR because ${ex} when EXECUTE ${message}", data = data)
    }
}