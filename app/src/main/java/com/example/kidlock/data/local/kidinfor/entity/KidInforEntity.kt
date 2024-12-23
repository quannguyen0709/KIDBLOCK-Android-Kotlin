package com.example.kidlock.data.local.kidinfor.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.kidlock.data.local.generic.EntityAbstract

@Entity(tableName = "kid_infor")
data class KidInforEntity(
    @PrimaryKey
    @ColumnInfo(name = "id")
    var kidId: String = "",

    @ColumnInfo(name = "parent_of_kid_id")
    var parentOfKidId: String = "",

    @ColumnInfo(name = "name")
    var name: String = "",

    @ColumnInfo(name = "age")
    var age: Int = 0,

    @ColumnInfo(name = "avatar")
    var avatar: String = "",

    @ColumnInfo(name = "block_id")
    var blockId: String = "",

): EntityAbstract(){
    override fun getNameTable(): String = "kid_infor"
    override fun getNamePrimaryKey(): String =  "id"
    fun getNameKidColum(): String = "name"
    fun getNameParentIdColum(): String = "parent_of_kid_id"
    fun getNameAgeColum(): String = "age"
    fun getAvatarColum(): String = "avatar"
    fun getBlockIdColum(): String = "block_id"

}
