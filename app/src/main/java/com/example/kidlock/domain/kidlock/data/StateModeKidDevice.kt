package com.example.kidlock.domain.kidlock.data

sealed class StateModeKidDevice {
    data class Parent(val state : String = "parent"): StateModeKidDevice()
    data class Child(val state: String = "child"): StateModeKidDevice()
    data class Lock(val state: String = "lock"): StateModeKidDevice()
}

