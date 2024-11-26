package com.example.kidlock.domain.kidlock.data

import java.time.format.DateTimeFormatter

data class HistoryActivityOfDevice(
    //thoi gian va loai app hoac web truy cap
    val deviceInfor: DeviceInfor,
    val timeActivityOfDevice: Map<DateTimeFormatter, String>,
)