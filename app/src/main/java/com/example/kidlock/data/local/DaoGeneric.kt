package com.example.kidlock.data.local

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Transaction
import androidx.room.Update

@Dao
interface DaoGeneric<T> {
    @Transaction
    @Insert
    fun insert(instance:T)
    @Transaction
    @Insert
    fun insertAll(instances: Array<T>)
    @Transaction
    @Update
    fun update(vararg instances: T)
    @Transaction
    @Delete
    fun delete(vararg instances: T)
}