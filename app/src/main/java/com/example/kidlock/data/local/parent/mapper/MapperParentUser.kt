package com.example.kidlock.data.local.parent.mapper

import com.example.kidlock.data.local.parent.entity.ParentUserEntity
import com.example.kidlock.domain.kidlock.data.KidUserInfor
import com.example.kidlock.domain.kidlock.data.ParentUser

fun ParentUser.toEnitity():ParentUserEntity{
    return ParentUserEntity(
        idParent = this.idPaerntUser,
        name = this.name,
        email = this.gmail,
        passWord = this.passWord,
        phone = this.phone,
        pin = this.PIN
    )
}
fun ParentUserEntity.toDomain(): ParentUser{
    return ParentUser(
        idPaerntUser = this.idParent,
        name = this.name,
        passWord = this.passWord,
        PIN = this.pin,
        gmail = this.email,
        phone = this.phone,
        managerKidOfParentUser =  arrayOf()
    )
}