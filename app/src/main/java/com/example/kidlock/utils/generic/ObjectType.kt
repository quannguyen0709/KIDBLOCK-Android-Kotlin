package com.example.kidlock.utils.generic

import com.example.kidlock.utils.resource.Resource

interface ObjectType<T> {
   suspend fun getInfor(idObject: String): T
}