package com.example.kidlock.domain.kidlock.data

sealed class StateModeKidDevice {
    class Parent: StateModeKidDevice()
    class Child: StateModeKidDevice()
    class Lock: StateModeKidDevice()
}