package com.example.kidlock.data.local.parent

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName = "parent_user")
data class ParentUserEntity (
    @PrimaryKey
    @ColumnInfo(name = "id_parent")
    private val idParent: String,
    @ColumnInfo(name = "name" )
    private val name: String,
    @ColumnInfo(name = "email")
    private val email: String,
    @ColumnInfo(name = "pass_word")
    private val passWord: String,
)

