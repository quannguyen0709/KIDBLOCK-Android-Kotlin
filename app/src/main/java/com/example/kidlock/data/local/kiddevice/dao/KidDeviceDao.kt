package com.example.kidlock.data.local.kiddevice.dao

import androidx.room.Dao
import com.example.kidlock.data.local.generic.DaoGeneric
import com.example.kidlock.data.local.kiddevice.entity.KidDeviceEntity

@Dao
abstract class KidDeviceDao: DaoGeneric<KidDeviceEntity>() {
}