package com.example.kidlock.data.local.historyaction.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class HistoryActionOfKidEntity(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id")
    val id:Int,
    @ColumnInfo(name = "time_unix_epoch")
    val timeUnix:String,
    @ColumnInfo(name = "time_human_readable")
    val timeFormatter: String,
    @ColumnInfo(name= "infor_block")
    val blockInfor: String,
)
