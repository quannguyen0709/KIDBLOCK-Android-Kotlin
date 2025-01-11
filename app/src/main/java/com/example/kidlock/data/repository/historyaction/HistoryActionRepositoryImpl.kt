package com.example.kidlock.data.repository.historyaction

import com.example.kidlock.data.local.historyaction.dao.HistoryActionDao
import com.example.kidlock.data.local.historyaction.dao.QueryHistoryActionOfKid
import com.example.kidlock.data.local.historyaction.entity.HistoryActionOfKidEntity
import com.example.kidlock.domain.model.HistoryActivityOfDevice
import com.example.kidlock.domain.model.KidUserInfor
import com.example.kidlock.domain.repository.HistoryActionOfDeviceRepository
import java.time.LocalDateTime
import java.util.Date
import javax.inject.Inject

class HistoryActionRepositoryImpl @Inject constructor(
    val historyActionDao: HistoryActionDao,
    val queryHistoryAction: QueryHistoryActionOfKid
) : HistoryActionOfDeviceRepository {
    override suspend fun submit(instance: HistoryActivityOfDevice, kidInfor: KidUserInfor) {
        TODO("Not yet implemented")

    }

    override suspend fun accept(instanceObject: HistoryActivityOfDevice) {
        TODO("Not yet implemented")
    }

    override suspend fun clear(instance: HistoryActivityOfDevice) {
        TODO("Not yet implemented")
    }

    override suspend fun getInfor(
        idObject: KidUserInfor,
        time: LocalDateTime
    ): List<HistoryActivityOfDevice> {
        TODO("Not yet implemented")
    }

}