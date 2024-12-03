package com.example.kidlock.data.local.kidinfor.dao

import androidx.room.Dao
import com.example.kidlock.data.local.generic.DaoGeneric
import com.example.kidlock.data.local.kidinfor.entity.KidInforEntity

@Dao
abstract class KidInforDao : DaoGeneric<KidInforEntity>(){
}