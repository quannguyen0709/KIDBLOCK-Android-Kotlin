package com.example.kidlock.domain.kidlock.data

data class KidUserDevices(
    val name: String,
    val age: Int,
    val avatar: String,
    val historyActivityOfKidOnDevices: Map<String, HistoryActivityOfDevice>,
    val listDevicesByKidUser : DeviceInfor,
    val stateModeKidActive: Map<String, StateModeKidDevice>
)
