package com.example.kidlock.data.local.kiddevice.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.kidlock.data.local.generic.EntityAbstract

@Entity(tableName = "kid_device")
data class KidDeviceEntity(
    @PrimaryKey
    @ColumnInfo(name = "kid_device_id")
    val kidDeviceId: String = "",

    @ColumnInfo(name = "kid_infor_creator_id")
    val kidInforId: String = "",

    @ColumnInfo(name = "name_device")
    val name: String = "",

    @ColumnInfo(name = "state_mode_kid_device")
    val stateMode: String = "",

    @ColumnInfo(name = "app_block")
    val appBlock: String = "",

    @ColumnInfo(name = "website_block")
    val websiteBlock: String = "",

    @ColumnInfo(name = "config_system")
    val configSystem: String = ""
): EntityAbstract(){
    override fun getNameTable(): String = "kid_device"
    override fun getNamePrimaryKey(): String = "kid_device_id"
    fun getNameKidInforColum(): String = "kid_infor_creator_id"
    fun getNameKidDeviceColum(): String = "name_device"
    fun getNameStateModeColum(): String = "state_mode_kid_device"
    fun getNameAppBlockColum(): String = "app_block"
    fun getNameWebsiteBlockColum(): String = "website_block"
    fun getNameConfigSystem(): String = "config_system"

}
