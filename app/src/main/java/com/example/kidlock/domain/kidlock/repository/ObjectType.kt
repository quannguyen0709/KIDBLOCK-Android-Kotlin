package com.example.kidlock.domain.kidlock.repository

interface ObjectType<T> {
    fun <IdObject>getInfor(idObject: IdObject):T
}