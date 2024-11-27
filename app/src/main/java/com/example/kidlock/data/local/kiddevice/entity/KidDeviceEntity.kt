package com.example.kidlock.data.local.kiddevice.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class KidDeviceEntity(
    @PrimaryKey
    @ColumnInfo(name = "kid_device_id")
     val kidDeviceId: String,
    @ColumnInfo(name = "name_device")
      val name: String,
    @ColumnInfo(name = "state_mode_kid_device")
      val stateMode: String,
    @ColumnInfo(name ="app_block")
     val appBlock: String,
    @ColumnInfo(name = "website_block")
     val websiteBlock : String,
    @ColumnInfo(name = "config_system")
     val configSystem:String

)
