package com.example.kidlock.domain.kidlock.service.parent

import com.example.kidlock.data.repository.parent.ParentRepositoryData
import com.example.kidlock.domain.kidlock.data.ParentUser
import com.example.kidlock.utils.generic.RepositoryGeneric
import com.example.kidlock.utils.resource.Resource
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

class ParentUserService (): RepositoryGeneric<ParentUser> {
    override suspend fun submit(instance: ParentUser) {
        TODO("Not yet implemented")
    }

    override suspend fun accept(instanceObject: ParentUser) {
        TODO("Not yet implemented")
    }

    override suspend fun clear(instance: ParentUser) {
        TODO("Not yet implemented")
    }

    override suspend fun getInfor(idObject: String): ParentUser {
        TODO("Not yet implemented")
    }

}