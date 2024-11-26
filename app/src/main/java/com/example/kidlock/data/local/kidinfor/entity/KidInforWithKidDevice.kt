package com.example.kidlock.data.local.kidinfor.entity

import androidx.room.Embedded
import androidx.room.Relation

data class KidInforWithKidDevice(
    @Embedded
    val kidInforId: String,
    @Relation(
        parentColumn = "kid_infor_id",
        entityColumn = "kid_device_id"
    )
    val kidDeviceId: Array<KidInforEntity>?
)
