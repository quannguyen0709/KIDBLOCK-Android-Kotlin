package com.example.kidlock.data.local.historyaction.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.Ignore
import androidx.room.PrimaryKey
import com.example.kidlock.data.local.generic.EntityAbstract
import java.util.Date

@Entity(tableName = "history_action_of_kid")
data class HistoryActionOfKidEntity(

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id")
    val id:Int = 0,

    @ColumnInfo(name = "kid_infor_creator_id")
    val kidInforId: String = "",

    @ColumnInfo(name = "kid_device_create_id")
    val kidDeviceId: String = "",

    @ColumnInfo(name = "time_unix_epoch")
    val timeUnix:String = "",

    @ColumnInfo(name = "time_human_readable")
    val timeFormatter: Date = Date(2024, 10, 30),

    @ColumnInfo(name= "infor_block")
    val blockInfor: String = "",
): EntityAbstract(){
    override fun getNameTable() = "history_action_of_kid"
    override fun getNamePrimaryKey(): String = "id"
    fun getNameKidInforColum(): String = "kid_infor_creator_id"
    fun getNameKidDeviceColum(): String = "kid_device_create_id"
    fun getNameTimeUnixColum(): String = "time_unix_epoch"
    fun getNameTimeFormatterColum(): String = "time_human_readable"
    fun getNameBlockInfor(): String = "infor_block"
}
