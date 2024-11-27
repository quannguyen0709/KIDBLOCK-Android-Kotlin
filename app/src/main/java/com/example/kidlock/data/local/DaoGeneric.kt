package com.example.kidlock.data.local

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Entity
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Transaction
import androidx.room.Update
import javax.annotation.Nonnull

@Dao
abstract class DaoGeneric<T> {
    @Transaction
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    abstract suspend fun insert(vararg instance :T)
    @Transaction
    @Update
    abstract fun update(vararg instances: T)
    @Transaction
    @Delete
    abstract fun delete(vararg instances: T)
}