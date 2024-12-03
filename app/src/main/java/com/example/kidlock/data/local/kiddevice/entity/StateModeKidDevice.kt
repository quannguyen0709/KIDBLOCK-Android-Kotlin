package com.example.kidlock.data.local.kiddevice.entity

sealed class StateModeKidDevice {
    class Parent: StateModeKidDevice()
    class Child: StateModeKidDevice()
    class Lock: StateModeKidDevice()
}

