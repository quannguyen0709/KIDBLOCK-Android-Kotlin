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
        val command = queryParent.queryGetEntity(instance.idPaerntUser )
        val id = GlobalScope.async(Dispatchers.IO) {
            try{
                parentDao.getEntity(command.toRawQuery())
            }catch (ex: Exception){
                println(ex.message)
            }
        }.await()
        println("  DAY LA TEST GETID CUA PARRENT  " + id)

        val a= GlobalScope.async (Dispatchers.IO){
            try {
                parentDao.getId(queryParent.queyGetIdEntity(instance.idPaerntUser).toRawQuery())
            }catch (ex: Exception){
                println("Exception GETIDPARENT" + ex)
            }

        }.await()
        println(a)
    }

    override fun <ComponentOfObject> accept(
        componentOfObject: ComponentOfObject,
        instanceObject: ParentUser
    ) {
        TODO("Not yet implemented")
    }

    override fun <String> clear(instance: String) {

        //databaseKidBlock.parentDao().delete()
    }

    override fun <String> getInfor(idObject: String) {
        TODO("Not yet implemented")
    }


}