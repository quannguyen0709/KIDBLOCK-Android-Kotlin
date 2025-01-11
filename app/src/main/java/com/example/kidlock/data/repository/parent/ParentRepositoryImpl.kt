package com.example.kidlock.data.repository.parent


import com.example.kidlock.data.local.generic.toRawQuery
import com.example.kidlock.data.local.parent.dao.ParentDao
import com.example.kidlock.data.local.parent.dao.QueryParent
import com.example.kidlock.data.local.parent.entity.ParentUserEntity
import com.example.kidlock.data.local.parent.mapper.toDomain
import com.example.kidlock.data.local.parent.mapper.toEnitity
import com.example.kidlock.domain.model.ParentUser
import com.example.kidlock.domain.repository.ParentUserRepositoryDomain
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.async
import javax.inject.Inject


class ParentRepositoryImpl @Inject constructor (
    val parentDao: ParentDao,
    val queryParent: QueryParent
): ParentUserRepositoryDomain {

    //@Throws(RuntimeException::class)
    override suspend fun submit(instance: ParentUser) {
        val parentUserEntity = instance.toEnitity()
        if (parentDao.insert(parentUserEntity).any().equals(-1) ) throw RuntimeException("Khong insert duoc parent")
    }

    override suspend fun accept(
        instanceObject: ParentUser
    ) {
        if (parentDao.update(instanceObject.toEnitity()) == -1) throw RuntimeException("Update khong thanh cong parent")
    }

    override suspend fun clear(instance: ParentUser) {
        if (parentDao.delete(instance.toEnitity()) == -1 )  throw RuntimeException("Khong co parent de delete ")
    }

    override suspend fun getInfor(idObject: String): ParentUser {
        val command = queryParent.queryGetEntity(idObject)
        val result : ParentUserEntity = GlobalScope.async(Dispatchers.IO) { parentDao.getEntity(command.toRawQuery()) }.await()
        if (result != null) return  return result.toDomain()
        throw RuntimeException("Khong tim thay parent user in db")
    }


}