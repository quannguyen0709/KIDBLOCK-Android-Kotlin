package com.example.kidlock.domain.repository

import com.example.kidlock.data.local.generic.toRawQuery
import com.example.kidlock.data.local.parent.entity.ParentUserEntity
import com.example.kidlock.data.local.parent.mapper.toDomain
import com.example.kidlock.data.local.parent.mapper.toEnitity
import com.example.kidlock.domain.model.KidUserInfor
import com.example.kidlock.domain.model.ParentUser
import com.example.kidlock.utils.generic.RepositoryGeneric
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.async

interface KidUserInforRepository  {
     suspend fun submit(instance: KidUserInfor, parentUser: ParentUser)

     suspend fun accept(instanceObject:  KidUserInfor)

     suspend fun clear(instance: KidUserInfor)

     suspend fun getInfor(idObject: String): KidUserInfor
}