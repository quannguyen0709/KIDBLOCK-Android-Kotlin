package com.example.kidlock.data.local.parent

import androidx.room.Embedded
import androidx.room.Relation
import com.example.kidlock.data.local.kidinfor.KidInforEntity

data class ParentWithKidInfor(
    @Embedded
    val parentId: String,
    @Relation(
        parentColumn = "id_parent",
        entityColumn = "kid_infor_id"
    )
    val kidInfor: Array<KidInforEntity>
)