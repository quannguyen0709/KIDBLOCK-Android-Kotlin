package com.example.kidlock.data.repository.kiddevice

import com.example.kidlock.data.local.kiddevice.dao.KidDeviceDao
import com.example.kidlock.data.local.kiddevice.dao.QueryKidDevice
import com.example.kidlock.data.local.kiddevice.entity.KidDeviceEntity
import com.example.kidlock.domain.model.DeviceInfor
import com.example.kidlock.domain.model.KidUserInfor
import com.example.kidlock.domain.repository.DeviceInforRepository
import javax.inject.Inject

class KidDeviceRepositoryImpl @Inject constructor(
    val kidDeviceDao: KidDeviceDao,
    val queryKidDevice: QueryKidDevice,
) : DeviceInforRepository {
    override suspend fun submit(instance: DeviceInfor, kidUserInfor: KidUserInfor) {
        TODO("Not yet implemented")
    }

    override suspend fun accept(instanceObject: DeviceInfor) {
        TODO("Not yet implemented")
    }

    override suspend fun clear(instance: DeviceInfor) {
        TODO("Not yet implemented")
    }

    override suspend fun getInfor(idObject: String): DeviceInfor {
        TODO("Not yet implemented")
    }


}