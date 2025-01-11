package com.example.kidlock.domain.model

import com.google.gson.annotations.SerializedName


data class DeviceInfor(
    @SerializedName("idDevices")

    var idDevices: String,
    @SerializedName("nameDevice")
    var nameDevice: String,

    @SerializedName("email")
    var emailParentUser:String,

    @SerializedName("listBlok")
    var listBlok: ArrayList<Block> = arrayListOf(),
    @SerializedName("stateModeKidDevice")
    var stateModeKidDevice: String
)
