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
    var id:Int = 0,

    @ColumnInfo(name = "kid_infor_id")
    var kidInforId: String = "",

    @ColumnInfo(name = "kid_device_id")
    var kidDeviceId: String = "",

    @ColumnInfo(name = "time_unix_epoch_day")
    var timeUnixDay:String = "",

    @ColumnInfo(name = "time_unix_epoch_hr")
    //pattern yy-MMMM-dd
    var timeUnixHours: String = "",

    @ColumnInfo(name= "block_id")
    val blockInfor: String = "",
): EntityAbstract(){
    override fun getNameTable() = "history_action_of_kid"
    override fun getNamePrimaryKey(): String = "id"
    fun getNameKidInforColum(): String = "kid_infor_id"
    fun getNameKidDeviceColum(): String = "kid_device_id"
    fun getNameTimeUnixDayColum(): String = "time_unix_epoch_day"
    fun getNameTimeUnixHoursColum(): String = "time_unix_epoch_hr"
    fun getNameBlockIdColum(): String = "block_id"
}
