package com.example.kidlock.data.local.parent.dao

import androidx.room.Dao
import androidx.room.Query
import com.example.kidlock.data.local.generic.DaoGeneric
import com.example.kidlock.data.local.parent.entity.ParentUserEntity

@Dao
public abstract class ParentDao: DaoGeneric<ParentUserEntity>() {

    //test query co the hoat dong bth
    @Query("SELECT id_parent  FROM parent_user  WHERE id_parent =  :id")
    abstract suspend fun getIdParent(id: String): String
}