package com.example.kidlock.domain.kidlock.service.parent

import com.example.kidlock.data.repository.parent.ParentRepositoryData
import com.example.kidlock.domain.kidlock.data.ParentUser
import com.example.kidlock.utils.generic.RepositoryGeneric
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

class ParentUserService (): RepositoryGeneric<ParentUser> {

    override fun submit(instance: ParentUser) {
        TODO("Not yet implemented")
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