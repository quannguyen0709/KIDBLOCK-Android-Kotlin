package com.example.kidlock.utils.resource

sealed class Resource<T>() {
    data class Success<T>(val message: String? = null,val data: T? = null): Resource<T>()
    data class Error<T>(val message: String? = null,val data: T? = null): Resource<T>()

}