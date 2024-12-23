package com.example.kidlock.domain.kidlock.data

import java.time.format.DateTimeFormatter

data class HistoryActivityOfDevice(
    //thoi gian va loai app hoac web truy cap
    var deviceInfor: DeviceInfor,
    var kidInfor: KidUserInfor,
    var timeActivityOfDevice: Map<DateTimeFormatter, Block>,
)