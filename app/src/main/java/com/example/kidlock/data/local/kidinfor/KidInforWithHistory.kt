package com.example.kidlock.data.local.kidinfor

import androidx.room.Embedded
import androidx.room.Relation
import com.example.kidlock.data.local.historyaction.HistoryActionOfKidEntity

data class KidInforWithHistory(
    @Embedded
    val kidInforId:String,
    @Relation(
        parentColumn = "kid_infor_id",
        entityColumn = "id"
    )
    val history:Array<HistoryActionOfKidEntity>
)
