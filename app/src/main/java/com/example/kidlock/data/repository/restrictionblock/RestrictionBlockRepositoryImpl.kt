package com.example.kidlock.data.repository.restrictionblock

import com.example.kidlock.data.local.restrictionblock.dao.QueryRestrictionBlock
import com.example.kidlock.data.local.restrictionblock.dao.RestrictionBlockDao
import com.example.kidlock.domain.model.Block
import javax.inject.Inject

class RestrictionBlockRepositoryImpl @Inject constructor(
    val restrictionBlockDao: RestrictionBlockDao,
    val queryRestrictionBlock: QueryRestrictionBlock
) : RestrictionBlockData {
    override suspend fun submit(instance: Block) {
        TODO("Not yet implemented")
    }

    override suspend fun accept(instanceObject: Block) {
        TODO("Not yet implemented")
    }

    override suspend fun clear(instance: Block) {
        TODO("Not yet implemented")
    }

    override suspend fun getInfor(idObject: String): Block {
        TODO("Not yet implemented")
    }
}