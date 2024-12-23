package com.example.kidlock.data.repository.parent

import android.provider.Settings.Global
import androidx.room.Insert
import androidx.room.RoomRawQuery
import androidx.sqlite.db.SimpleSQLiteQuery
import androidx.sqlite.db.SupportSQLiteQuery
import com.example.kidlock.data.di.LocalDataKidBlock
import com.example.kidlock.data.infrastructure.database.KidBlockDatabase
import com.example.kidlock.data.local.generic.QueryGeneric
import com.example.kidlock.data.local.generic.toRawQuery
import com.example.kidlock.data.local.parent.dao.ParentDao
import com.example.kidlock.data.local.parent.dao.QueryParent
import com.example.kidlock.data.local.parent.entity.ParentUserEntity
import com.example.kidlock.data.local.parent.mapper.toDomain
import com.example.kidlock.data.local.parent.mapper.toEnitity
import com.example.kidlock.domain.kidlock.data.ParentUser
import com.example.kidlock.utils.resource.Resource
import com.example.kidlock.utils.resource.executeAsynchronous
import dagger.hilt.EntryPoint
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.async
import kotlinx.coroutines.launch
import javax.inject.Inject
import kotlin.coroutines.suspendCoroutine
import kotlin.jvm.Throws


class ParentRepositoryImpl @Inject constructor (
    val parentDao: ParentDao,
    val queryParent: QueryParent
): ParentRepositoryData {

    //@Throws(RuntimeException::class)
    override suspend fun submit(instance: ParentUser) {
        val parentUserEntity = instance.toEnitity()
        if (parentDao.insert(parentUserEntity).any().equals(-1) ) throw RuntimeException("Khong insert duoc parent")
    }

    override suspend fun accept(
        instanceObject: ParentUser
    ) {
        if (parentDao.update(instanceObject.toEnitity()) == -1) throw RuntimeException("Update khong thanh cong parent")
    }

    override suspend fun clear(instance: ParentUser) {
        if (parentDao.delete(instance.toEnitity()) == -1 )  throw RuntimeException("Khong co parent de delete ")
    }

    override suspend fun getInfor(idObject: String): ParentUser {
        val command = queryParent.queryGetEntity(idObject)
        val result : ParentUserEntity = GlobalScope.async(Dispatchers.IO) { parentDao.getEntity(command.toRawQuery()) }.await()
        if (result != null) return  return result.toDomain()
        throw RuntimeException("Khong tim thay parent user in db")
    }


}