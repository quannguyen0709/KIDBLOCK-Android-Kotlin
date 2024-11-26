package com.example.kidlock.domain.kidlock.data

data class DeviceInfor(
    val idDevices: String,
    val appsBlock: Map<String, String>,
    val websitesBlock: Map<String, String>,
    val stateModeKidDevice: StateModeKidDevice
)
