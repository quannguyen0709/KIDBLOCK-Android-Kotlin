package com.example.kidlock.data.local.restrictionblock.dao

import androidx.room.Dao
import com.example.kidlock.data.local.generic.DaoGeneric
import com.example.kidlock.data.local.restrictionblock.entity.RestrictionBlockEntity

@Dao
abstract class RestrictionBlockDao : DaoGeneric<RestrictionBlockEntity>() {
}