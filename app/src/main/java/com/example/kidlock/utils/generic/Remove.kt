package com.example.kidlock.utils.generic

import com.example.kidlock.utils.resource.Resource

interface Remove <T>{
    suspend fun clear(instance: T)
}