package com.example.kidlock.domain.kidlock.repository

interface Create<T> {
    fun submit(instance: T);
}