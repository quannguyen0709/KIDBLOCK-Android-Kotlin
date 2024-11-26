package com.example.kidlock.utils.resource

sealed class Resource<T>(val data: T? = null, val message: String? = null) {
    class Success<T>(message: String,data: T?): Resource<T>(data, message)
    class Error<T>(message: String, data: T? = null): Resource<T>(data, message)

}