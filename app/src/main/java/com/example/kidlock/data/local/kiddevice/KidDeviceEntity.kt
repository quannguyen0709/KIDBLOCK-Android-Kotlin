package com.example.kidlock.data.local.kiddevice

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class KidDeviceEntity(
    @PrimaryKey
    @ColumnInfo(name = "kid_device_id")
    private val kidDeviceId: String,
    @ColumnInfo(name = "name_device")
    private  val name: String,
    @ColumnInfo(name = "state_mode_kid_device")
    private  val stateMode: StateModeKidDevice,
    @ColumnInfo(name ="app_block")
    private val appBlock: Map<String, String>,
    @ColumnInfo(name = "website_block")
    private val websiteBlock : Map<String, String>,
    @ColumnInfo(name = "config_system")
    private val configSystem: Map<String, Boolean>

)
