package com.example.kidlock.data.local.restrictionblock.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.kidlock.data.local.generic.EntityAbstract

@Entity(tableName = "restriction_block")
data class RestrictionBlockEntity(
    @PrimaryKey
    @ColumnInfo(name = "block_id")
    var blockId: String = "",

    @ColumnInfo(name = "type_block")
    var typeBlock: String = "",

    @ColumnInfo(name = "block_infor")
    var blockInfor: String= "",

    @ColumnInfo(name = "image_by_base64")
    var image: String = " "
): EntityAbstract(){
    override fun getNameTable(): String = "restriction_block"

    override fun getNamePrimaryKey(): String = "block_id"

    fun getNameTypeBlockColum(): String = "type_block"

    fun getNameBlockInfor(): String = "block_infor"

    fun getNameImage(): String = "image_by_base64"
}
