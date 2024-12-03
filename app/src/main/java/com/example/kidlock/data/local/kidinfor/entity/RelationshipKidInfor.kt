package com.example.kidlock.data.local.kidinfor.entity

import androidx.room.Embedded
import androidx.room.Relation
import com.example.kidlock.data.local.historyaction.entity.HistoryActionOfKidEntity
import com.example.kidlock.data.local.kiddevice.entity.KidDeviceEntity

data class KidInforWithKidDevices(
    @Embedded
    val kidInforEntity: KidInforEntity,
    @Relation(
        parentColumn = "kid_infor_id",
        entityColumn = "kid_infor_creator_id"
    )
    val listKidDeviceEntity:List<KidDeviceEntity>
    )

data class KidInforWithHistoryAction(
    @Embedded
    val kidInforEntity: KidInforEntity,
    @Relation(
        parentColumn = "kid_infor_id",
        entityColumn = "kid_infor_creator_id"
    )
    val listHistoryAction: List<HistoryActionOfKidEntity>
)