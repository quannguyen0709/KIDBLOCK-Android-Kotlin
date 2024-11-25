package com.example.kidlock.domain.proxy.parent

import com.example.kidlock.domain.kidlock.data.ParentUser

class ServiceImpl: com.example.kidlock.domain.proxy.parent.Service {
    override fun submit(instance: ParentUser) {
        TODO("Not yet implemented")

    }

    override fun <ComponentOfObject> submit(
        componentOfObject: ComponentOfObject,
        instanceObject: ParentUser
    ) {
        TODO("Not yet implemented")
    }

    override fun <ComponentOfObject> submit(componentOfObject: ComponentOfObject) {
        TODO("Not yet implemented")
    }

    override fun <IdObject> getInfor(idObject: IdObject): ParentUser {
        TODO("Not yet implemented")
    }


}