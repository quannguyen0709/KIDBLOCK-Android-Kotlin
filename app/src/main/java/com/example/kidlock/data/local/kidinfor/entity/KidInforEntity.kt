package com.example.kidlock.data.local.kidinfor.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class KidInforEntity(
    @PrimaryKey
    @ColumnInfo(name = "kid_infor_id")
     val kidId: String,
    @ColumnInfo(name= "name")
     val name: String,
    @ColumnInfo(name = "age")
      val age : Int,
    @ColumnInfo(name = "avatar")
     val avatar: String
)
