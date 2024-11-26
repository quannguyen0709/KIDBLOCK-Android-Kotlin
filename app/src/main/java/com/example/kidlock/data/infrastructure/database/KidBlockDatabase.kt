package com.example.kidlock.data.infrastructure.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.kidlock.data.local.historyaction.dao.HistoryActionDao
import com.example.kidlock.data.local.historyaction.entity.HistoryActionOfKidEntity
import com.example.kidlock.data.local.kiddevice.dao.KidDeviceDao
import com.example.kidlock.data.local.kiddevice.entity.KidDeviceEntity
import com.example.kidlock.data.local.kidinfor.dao.KidInforDao
import com.example.kidlock.data.local.kidinfor.entity.KidInforEntity
import com.example.kidlock.data.local.parent.dao.ParentDao
import com.example.kidlock.data.local.parent.entity.ParentUserEntity

@Database(entities = [ParentUserEntity::class, KidInforEntity::class, HistoryActionOfKidEntity::class, KidDeviceEntity::class], version = 1, exportSchema = false)
abstract class KidBlockDatabase : RoomDatabase() {
    abstract fun parentDao():ParentDao
    abstract fun kidInforDao():KidInforDao
    abstract fun kidDeviceDao():KidDeviceDao
    abstract fun historyActionDao():HistoryActionDao
}