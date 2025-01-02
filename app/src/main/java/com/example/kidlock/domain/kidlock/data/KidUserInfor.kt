package com.example.kidlock.domain.kidlock.data


data class KidUserInfor(
    var id: String ,
    var name: String,
    var age: Int,
    var avatar: String,
    var historyActivityOfKidOnDevices: Map<String, HistoryActivityOfDevice> = hashMapOf(),
    var listDevicesByKidUser : Array<DeviceInfor> = arrayOf(),
    var listBlock: Array<Block> = arrayOf()
)
