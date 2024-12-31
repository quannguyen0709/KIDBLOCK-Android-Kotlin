package com.example.kidlock.domain.kidlock.service.parent

import com.example.kidlock.data.repository.parent.ParentRepositoryData
import com.example.kidlock.domain.kidlock.data.ParentUser
import com.example.kidlock.domain.kidlock.repository.parent.ParentUserRepositoryDomain
import com.example.kidlock.utils.generic.RepositoryGeneric
import com.example.kidlock.utils.resource.Resource
import com.example.kidlock.utils.resource.executeAsynchronous
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

class ParentUserService @Inject constructor(
    val parentUserRepositoryData: ParentRepositoryData,
): ParentUserRepositoryDomain {
    override suspend fun createParentUser(instance: ParentUser): Resource<ParentUser> {
        return executeAsynchronous<ParentUser>(
            callBack = { parentUserRepositoryData.submit(instance) },
            message = "Create account Parent",
            data = instance,
            )
    }

    override suspend fun updateParentUser(instance: ParentUser): Resource<ParentUser> {
        return Resource.Success<ParentUser>()
    }

    override suspend fun deleteParentUser(instance: ParentUser): Resource<ParentUser> {
        return Resource.Success<ParentUser>()
    }


}