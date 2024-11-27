package com.example.kidlock.utils.generic

interface Update<T> {
    fun  <ComponentOfObject>accept(componentOfObject: ComponentOfObject, instanceObject: T)
}