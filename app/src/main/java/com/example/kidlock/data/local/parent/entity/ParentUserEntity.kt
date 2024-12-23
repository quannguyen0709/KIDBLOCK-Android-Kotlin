package com.example.kidlock.data.local.parent.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.kidlock.data.local.generic.EntityAbstract


@Entity(tableName = "parent_user")
data class ParentUserEntity (
    @PrimaryKey
    @ColumnInfo(name = "id")
     var idParent: String = "",

    @ColumnInfo(name = "name" )
     var name: String = "",

    @ColumnInfo(name = "email")
     var email: String = "",

    @ColumnInfo(name = "password")
     var passWord: String = "",

    @ColumnInfo(name = "pin")
    var pin: Int = 0,

    @ColumnInfo(name = "phone")
    var phone:String = ""

): EntityAbstract(){
    override fun getNameTable(): String = "parent_user"
    override fun getNamePrimaryKey(): String = "id"
    fun getNameParentColum(): String = "name"
    fun getNameEmailColum(): String = "email"
    fun getNamePasswordColum(): String = "password"
    fun getNamePinColum(): String = "pin"
    fun getNamePhoneColum(): String = "phone"
}


