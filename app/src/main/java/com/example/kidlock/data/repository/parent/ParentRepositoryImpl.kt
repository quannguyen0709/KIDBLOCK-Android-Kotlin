package com.example.kidlock.data.repository.parent

import android.provider.Settings.Global
import androidx.room.Insert
import com.example.kidlock.data.di.LocalDataKidBlock
import com.example.kidlock.data.infrastructure.database.KidBlockDatabase
import com.example.kidlock.data.local.parent.mapper.toEnitity
import com.example.kidlock.domain.kidlock.data.ParentUser
import dagger.hilt.EntryPoint
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.async
import kotlinx.coroutines.launch
import javax.inject.Inject


class ParentRepositoryImpl @Inject constructor(val databaseKidBlock: KidBlockDatabase): ParentRepositoryData {

    override suspend fun submit(instance: ParentUser) {

        val parentUserEntity = instance.toEnitity()
        databaseKidBlock.parentDao().insert(parentUserEntity)
    }

    override fun <ComponentOfObject> accept(
        componentOfObject: ComponentOfObject,
        instanceObject: ParentUser
    ) {

    }

    override fun <IdOfInstane> clear(instance: IdOfInstane) {
    }

    override fun <IdObject> getInfor(idObject: IdObject): ParentUser {
        TODO("Not yet implemented")
    }


}