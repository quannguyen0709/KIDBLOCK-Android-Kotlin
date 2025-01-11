package com.example.kidlock.domain.model

import com.google.gson.annotations.SerializedName


data class KidUserInfor(
    @SerializedName("id")
    var id: String,
    @SerializedName("name")
    var name: String,
    @SerializedName("age")
    var age: Int,
    @SerializedName("avatar")
    var avatar: String,
    @SerializedName("historyActivityOfKidOnDevices")
    var historyActivityOfKidOnDevices: ArrayList<HistoryActivityOfDevice>,
    @SerializedName("listDevicesByKidUser")
    var listDevicesByKidUser : ArrayList<DeviceInfor> = arrayListOf(),
    @SerializedName("listBlock")
    var listBlock: ArrayList<Block> = arrayListOf()
)
