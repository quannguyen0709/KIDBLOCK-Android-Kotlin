package com.example.kidlock.utils.generic

import com.example.kidlock.utils.resource.Resource

interface Update<T> {
    fun  <ComponentOfObject>accept(componentOfObject: ComponentOfObject, instanceObject: T)
}