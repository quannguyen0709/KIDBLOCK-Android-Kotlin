package com.example.kidlock.data.local.parent.dao

import androidx.room.Dao
import androidx.room.Insert
import com.example.kidlock.data.local.DaoGeneric
import com.example.kidlock.data.local.parent.entity.ParentUserEntity

@Dao
public abstract class ParentDao: DaoGeneric<ParentUserEntity>() {
}