package com.example.kidlock.data.local.kiddevice.entity

sealed class StateModeKidDevice {
   data class Parent(val state : String = "parent"): StateModeKidDevice()
    data class Child(val state: String = "child"): StateModeKidDevice()
    data class Lock(val state: String = "lock"): StateModeKidDevice()
}

