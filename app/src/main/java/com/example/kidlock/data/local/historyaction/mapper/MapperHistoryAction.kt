package com.example.kidlock.data.local.historyaction.mapper

import com.example.kidlock.data.local.historyaction.entity.HistoryActionOfKidEntity
import com.example.kidlock.domain.model.Block
import com.example.kidlock.domain.model.DeviceInfor
import com.example.kidlock.domain.model.HistoryActivityOfDevice
import com.example.kidlock.utils.gson.fromJsonToObject
import com.example.kidlock.utils.gson.toJsonFromObject
import java.time.Instant
import java.time.LocalDate
import java.time.LocalDateTime
import java.time.ZoneId
import java.time.format.DateTimeFormatter
import java.util.Date

fun HistoryActivityOfDevice.toEntity(idKidInfor: String): HistoryActionOfKidEntity{
    val fommaterHours = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm")
    val fommaterDay = DateTimeFormatter.ofPattern("yyyy-MM-dd ")

    return HistoryActionOfKidEntity(
        kidInforId =  idKidInfor,
        blockInfor = toJsonFromObject(this.block),
        kidDeviceId = this.deviceInfor.idDevices,
        timeUnixHours = LocalDate.parse(this.timeActivityOfDevice, fommaterHours).atStartOfDay(ZoneId.systemDefault()).toInstant().epochSecond.toString(),
        timeUnixDay = LocalDate.parse(this.timeActivityOfDevice, fommaterDay).atStartOfDay(ZoneId.systemDefault()).toInstant().epochSecond.toString()
        )
}

fun HistoryActionOfKidEntity.toModel( deviceInfor: DeviceInfor): HistoryActivityOfDevice{
    val instant = Instant.ofEpochMilli(this.timeUnixHours.toLong())
    val localDate = instant.atZone(ZoneId.systemDefault()).toLocalDateTime()
    val fommaterHours = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm")
    return  HistoryActivityOfDevice(
        timeActivityOfDevice = localDate.format(fommaterHours),
        deviceInfor = deviceInfor,
        block = fromJsonToObject<Block>(this.blockInfor),
    )
}