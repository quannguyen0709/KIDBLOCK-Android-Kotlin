package com.example.kidlock.domain.model

import com.google.gson.annotations.SerializedName
import java.time.LocalDateTime
import java.util.Date

data class HistoryActivityOfDevice(
    //thoi gian va loai app hoac web truy cap
    @SerializedName("deviceInfor")
    var deviceInfor: DeviceInfor,
    @SerializedName("timeActivityOfDevice")
    //pattern
    var timeActivityOfDevice: String,
    @SerializedName("block")
    var block: Block
)