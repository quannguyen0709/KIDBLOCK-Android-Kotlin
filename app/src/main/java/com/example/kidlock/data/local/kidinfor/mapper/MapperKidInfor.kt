package com.example.kidlock.data.local.kidinfor.mapper

import com.example.kidlock.data.local.kidinfor.entity.KidInforEntity
import com.example.kidlock.domain.model.Block
import com.example.kidlock.domain.model.DeviceInfor
import com.example.kidlock.domain.model.KidUserInfor
import com.example.kidlock.utils.gson.fromJsonToObject
import com.example.kidlock.utils.gson.toJsonFromObject

fun KidUserInfor.toEntity(idParent: String): KidInforEntity{
    return KidInforEntity(
        name = this.name,
        age =  this.age,
        kidId = this.id,
        parentOfKidId = idParent,
        avatar = this.avatar,
        blockId = toJsonFromObject( this.listBlock)
    )
}

fun KidInforEntity.toModel(listDevice: ArrayList<DeviceInfor>): KidUserInfor{
    return KidUserInfor(
         id = this.kidId,
        avatar =  this.avatar,
        name =  this.name,
        age = this.age,
        listBlock =  fromJsonToObject<ArrayList<Block>>(this.blockId),
        listDevicesByKidUser = listDevice,
        historyActivityOfKidOnDevices = arrayListOf()
    )
}