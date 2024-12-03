package com.example.kidlock.data.local.kidinfor.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.kidlock.data.local.generic.EntityAbstract

@Entity(tableName = "kid_infor")
data class KidInforEntity(
    @PrimaryKey
    @ColumnInfo(name = "kid_infor_id")
    val kidId: String = "",

    @ColumnInfo(name = "parent_of_kid_id")
    val parentOfKidId: String = "",

    @ColumnInfo(name = "name")
    val name: String = "",

    @ColumnInfo(name = "age")
    val age: Int = 0,

    @ColumnInfo(name = "avatar")
    val avatar: String = "",

    @ColumnInfo(name = "app_block")
    val appBlock: String = "",

    @ColumnInfo(name = "website_block")
    val websiteBlock: String = "",

    @ColumnInfo(name = "kid_devices")
    val kidDevice: String = "",

): EntityAbstract(){
    override fun getNameTable(): String = "kid_infor"
    override fun getNamePrimaryKey(): String =  "kid_infor_id"
    fun getNameKidColum(): String = "name"
    fun getNameParentIdColum(): String = "parent_of_kid_id"
    fun getNameAgeColum(): String = "age"
    fun getAvatarColum(): String = "avatar"
    fun getAppBlockColum(): String = "app_block"
    fun getWebsiteBlockColum(): String = "website_block"
    fun getKidDevicesColum(): String = "kid_devices"

}
