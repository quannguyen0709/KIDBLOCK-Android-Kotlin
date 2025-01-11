package com.example.kidlock.domain.repository

import com.example.kidlock.domain.model.DeviceInfor
import com.example.kidlock.domain.model.KidUserInfor
import com.example.kidlock.domain.model.ParentUser
import com.example.kidlock.utils.generic.RepositoryGeneric

interface DeviceInforRepository  {
    suspend fun submit(instance: DeviceInfor, kidUserInfor: KidUserInfor)

    suspend fun accept(instanceObject: DeviceInfor)

    suspend fun clear(instance: DeviceInfor)

    suspend fun getInfor(idObject: String): DeviceInfor
}