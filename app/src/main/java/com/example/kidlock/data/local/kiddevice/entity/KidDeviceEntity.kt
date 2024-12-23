package com.example.kidlock.data.local.kiddevice.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.kidlock.data.local.generic.EntityAbstract

@Entity(tableName = "kid_device")
data class KidDeviceEntity(
    @PrimaryKey
    @ColumnInfo(name = "id")
    var kidDeviceId: String = "",

    @ColumnInfo(name = "kid_infor_id")
    var kidInforId: String = "",

    @ColumnInfo(name = "name_device")
    var name: String = "",

    @ColumnInfo(name = "state_mode_kid_device")
    var stateMode: String = "",

    @ColumnInfo(name = "block_id")
    var blockId: String = "",

    @ColumnInfo(name = "config_system")
    var configSystem: String = ""
): EntityAbstract(){
    override fun getNameTable(): String = "kid_device"
    override fun getNamePrimaryKey(): String = "id"
    fun getNameKidInforColum(): String = "kid_infor_id"
    fun getNameKidDeviceColum(): String = "name_device"
    fun getNameStateModeColum(): String = "state_mode_kid_device"
    fun getNameBlockIdColum(): String = "block_id"
    fun getNameConfigSystem(): String = "config_system"

}
