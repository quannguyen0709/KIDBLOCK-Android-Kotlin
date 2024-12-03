package com.example.kidlock.data.local.historyaction.dao

import androidx.room.Dao
import com.example.kidlock.data.local.generic.DaoGeneric
import com.example.kidlock.data.local.historyaction.entity.HistoryActionOfKidEntity

@Dao
abstract class HistoryActionDao: DaoGeneric<HistoryActionOfKidEntity>() {
}