package com.example.kidlock.utils.generic

import com.example.kidlock.utils.resource.Resource

interface Update<T> {
    suspend fun  accept( instanceObject: T)
}