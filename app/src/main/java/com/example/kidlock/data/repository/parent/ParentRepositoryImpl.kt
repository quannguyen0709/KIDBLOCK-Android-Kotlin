package com.example.kidlock.data.repository.parent

import androidx.room.Insert
import com.example.kidlock.data.di.LocalDataKidBlock
import com.example.kidlock.data.infrastructure.database.KidBlockDatabase
import com.example.kidlock.data.local.parent.mapper.toEnitity
import com.example.kidlock.domain.kidlock.data.ParentUser
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject


@AndroidEntryPoint
class ParentRepositoryImpl @Inject constructor(val databaseKidBlock: KidBlockDatabase): ParentRepositoryData {

    override fun submit(instance: ParentUser) {
        TODO("Not yet implemented")
        val parentUserEntity = instance.toEnitity()
        databaseKidBlock.parentDao().insert(parentUserEntity)
    }

    override fun <ComponentOfObject> submit(
        componentOfObject: ComponentOfObject,
        instanceObject: ParentUser
    ) {
        TODO("Not yet implemented")
    }

    override fun <IdOfInstane> submit(instance: IdOfInstane) {
        TODO("Not yet implemented")
    }

    override fun <IdObject> getInfor(idObject: IdObject): ParentUser {
        TODO("Not yet implemented")
    }
}