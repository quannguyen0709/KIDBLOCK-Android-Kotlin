package com.example.kidlock.domain.kidlock.repository

interface Update<T> {
    fun  <ComponentOfObject>submit(componentOfObject: ComponentOfObject, instanceObject: T)
}