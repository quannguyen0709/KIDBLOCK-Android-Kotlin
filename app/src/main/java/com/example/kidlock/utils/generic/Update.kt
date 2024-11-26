package com.example.kidlock.utils.generic

interface Update<T> {
    fun  <ComponentOfObject>submit(componentOfObject: ComponentOfObject, instanceObject: T)
}