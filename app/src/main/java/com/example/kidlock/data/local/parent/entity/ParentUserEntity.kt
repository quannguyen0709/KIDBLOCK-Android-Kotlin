package com.example.kidlock.data.local.parent.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.kidlock.data.local.generic.EntityAbstract


@Entity(tableName = "parent_user")
data class ParentUserEntity (
    @PrimaryKey
    @ColumnInfo(name = "id_parent")
     val idParent: String = "",

    @ColumnInfo(name = "name" )
     val name: String = "",

    @ColumnInfo(name = "email")
     val email: String = "",

    @ColumnInfo(name = "password")
     val passWord: String = "",

    @ColumnInfo(name = "pin")
    val pin: Int = 0,

    @ColumnInfo(name = "phone")
    val phone:String = ""

): EntityAbstract(){
    override fun getNameTable(): String = "parent_user"
    override fun getNamePrimaryKey(): String = "id_parent"
    fun getNameParentColum(): String = "name"
    fun getNameEmailColum(): String = "email"
    fun getNamePasswordColum(): String = "password"
    fun getNamePinColum(): String = "pin"
    fun getNamePhoneColum(): String = "phone"
}


