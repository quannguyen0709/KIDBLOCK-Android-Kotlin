package com.example.kidlock.data.local.kiddevice.mapper

import com.example.kidlock.data.local.kiddevice.entity.KidDeviceEntity
import com.example.kidlock.domain.model.Block
import com.example.kidlock.domain.model.DeviceInfor
import com.example.kidlock.utils.gson.fromJsonToObject
import com.example.kidlock.utils.gson.toJsonFromObject

fun DeviceInfor.toEntity(idKidInfor: String): KidDeviceEntity{
    return KidDeviceEntity(
        name = this.nameDevice,
        kidDeviceId =  this.idDevices,
        kidInforId =  idKidInfor,
        stateMode = this.stateModeKidDevice,
        blockId = toJsonFromObject(this.listBlok),
        configSystem = ""
    )
}

fun KidDeviceEntity.toModel(): DeviceInfor{
    return DeviceInfor(
        idDevices = this.kidDeviceId,
        nameDevice = this.name,
        stateModeKidDevice = this.stateMode,
        emailParentUser = "",
        listBlok =  fromJsonToObject<ArrayList<Block>>(this.blockId)
    )
}