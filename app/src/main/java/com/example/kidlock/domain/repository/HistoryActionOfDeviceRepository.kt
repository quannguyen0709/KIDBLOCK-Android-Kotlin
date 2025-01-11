package com.example.kidlock.domain.repository

import com.example.kidlock.domain.model.HistoryActivityOfDevice
import com.example.kidlock.domain.model.KidUserInfor
import com.example.kidlock.domain.model.ParentUser
import com.example.kidlock.utils.generic.RepositoryGeneric
import java.time.LocalDateTime
import java.util.Date

interface HistoryActionOfDeviceRepository  {
    suspend fun submit(instance: HistoryActivityOfDevice, kidInfor: KidUserInfor)

    suspend fun accept(instanceObject: HistoryActivityOfDevice)

    suspend fun clear(instance: HistoryActivityOfDevice)

    suspend fun getInfor(idObject: KidUserInfor,time: LocalDateTime): List<HistoryActivityOfDevice>
}