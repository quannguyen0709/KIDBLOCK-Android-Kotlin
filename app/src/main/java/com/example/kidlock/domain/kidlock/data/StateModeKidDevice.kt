package com.example.kidlock.domain.kidlock.data

sealed class StateModeKidDevice {
    data class Parent(val parent:String): StateModeKidDevice()
    data class Child(val child: String): StateModeKidDevice()
    data class Lock(val lock: String): StateModeKidDevice()
}