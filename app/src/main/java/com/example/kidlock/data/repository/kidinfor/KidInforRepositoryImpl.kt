package com.example.kidlock.data.repository.kidinfor

import com.example.kidlock.data.local.kidinfor.dao.KidInforDao
import com.example.kidlock.data.local.kidinfor.dao.QueryKidInfor
import com.example.kidlock.domain.model.KidUserInfor
import com.example.kidlock.domain.model.ParentUser
import com.example.kidlock.domain.repository.KidUserInforRepository
import javax.inject.Inject

class KidInforRepositoryImpl @Inject constructor(
    val kidInforDao: KidInforDao,
    val queryKidInfor: QueryKidInfor
): KidUserInforRepository {
    override suspend fun submit(instance: KidUserInfor, parentUser: ParentUser) {
        TODO("Not yet implemented")
    }

    override suspend fun accept(instanceObject: KidUserInfor) {
        TODO("Not yet implemented")
    }

    override suspend fun clear(instance: KidUserInfor) {
        TODO("Not yet implemented")
    }

    override suspend fun getInfor(idObject: String): KidUserInfor {
        TODO("Not yet implemented")
    }


}