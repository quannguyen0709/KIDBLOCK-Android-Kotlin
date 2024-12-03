package com.example.kidlock.data.local.parent.entity

import androidx.room.Embedded
import androidx.room.Relation
import com.example.kidlock.data.local.kidinfor.entity.KidInforEntity


data class ParentWithKidsInfor (
    @Embedded
    val parentUserEntity: ParentUserEntity,
    @Relation(
        parentColumn = "id_parent",
        entityColumn = "parent_of_kid_id"
    )
    val listKidInforEntity: List<KidInforEntity>
)