package com.example.kidlock.data.local.parent.mapper

import com.example.kidlock.data.local.parent.entity.ParentUserEntity
import com.example.kidlock.domain.kidlock.data.KidUserInfor
import com.example.kidlock.domain.kidlock.data.ParentUser
import com.example.kidlock.utils.mapper.mapping
import kotlin.reflect.full.memberProperties

fun ParentUser.toEnitity():ParentUserEntity{
    val mapping: Map<String, String> = mapOf(
        "id" to "idParent",
        "name" to "name",
        "gmail" to "email",
        "phone" to "phone",
        "passWord" to "passWord",
        "PIN" to "pin"
    )
    val parentUserEntity : ParentUserEntity = mapping(source  = this, mapping= mapping, objectTarget = ParentUserEntity()) as ParentUserEntity

    return parentUserEntity
}
fun ParentUserEntity.toDomain(): ParentUser{
    return ParentUser(
        id = this.idParent,
        name = this.name,
        passWord = this.passWord,
        PIN = this.pin,
        gmail = this.email,
        phone = this.phone,
        managerKidOfParentUser =  arrayOf()
    )
}