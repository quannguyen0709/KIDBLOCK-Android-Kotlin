package com.example.kidlock.data.local.parent.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName = "parent_user")
data class ParentUserEntity (
    @PrimaryKey
    @ColumnInfo(name = "id_parent")
     val idParent: String,
    @ColumnInfo(name = "name" )
     val name: String,
    @ColumnInfo(name = "email")
     val email: String,
    @ColumnInfo(name = "pass_word")
     val passWord: String,
    @ColumnInfo(name = "pin")
    val pin: Int,
    @ColumnInfo(name = "phone")
    val phone:String
)

