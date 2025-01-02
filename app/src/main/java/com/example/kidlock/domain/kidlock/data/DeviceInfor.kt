package com.example.kidlock.domain.kidlock.data


data class DeviceInfor(
    var idDevices: String,
    var nameDevice: String,
    var listBlok: Array<Block> = arrayOf(),
    var stateModeKidDevice: StateModeKidDevice
)
