package com.example.kidlock.utils.generic

interface Create<T> {
    fun submit(instance: T);
}