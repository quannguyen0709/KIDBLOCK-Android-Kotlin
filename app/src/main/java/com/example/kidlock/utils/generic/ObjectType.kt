package com.example.kidlock.utils.generic

interface ObjectType<T> {
    fun <IdObject>getInfor(idObject: IdObject):T
}