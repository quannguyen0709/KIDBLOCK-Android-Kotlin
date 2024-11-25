package com.example.kidlock.data.local.kidinfor

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class KidInforEntity(
    @PrimaryKey
    @ColumnInfo(name = "kid_infor_id")
    private val kidId: String,
    @ColumnInfo(name= "name")
    private val name: String,
    @ColumnInfo(name = "age")
    private  val age : Int,
    @ColumnInfo(name = "avatar")
    private val avatar: String
)
