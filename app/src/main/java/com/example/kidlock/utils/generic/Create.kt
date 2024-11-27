package com.example.kidlock.utils.generic

interface Create<T> {
     suspend fun submit(instance: T);
}