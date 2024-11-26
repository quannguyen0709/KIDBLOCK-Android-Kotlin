package com.example.kidlock.domain.kidlock.data

data class KidUserInfor(
    val name: String,
    val age: Int,
    val avatar: String,
    val historyActivityOfKidOnDevices: Map<String, HistoryActivityOfDevice>,
    val listDevicesByKidUser : Array<DeviceInfor>,
)
