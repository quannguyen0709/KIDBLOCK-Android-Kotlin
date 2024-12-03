package com.example.kidlock.data.local.generic

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.RawQuery
import androidx.room.RoomRawQuery
import androidx.room.Transaction
import androidx.room.Update
import androidx.sqlite.db.SupportSQLiteQuery
import androidx.sqlite.db.SupportSQLiteQueryBuilder
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.async
import java.util.Objects


@Dao
abstract class DaoGeneric<T>{
    @Transaction
    @Insert(onConflict = OnConflictStrategy.REPLACE,)
    // returns row that entity was inserted at or -1 on failure
    abstract suspend fun insert(vararg instance :T):List<Long>

    @Transaction
    @Update
    // returns the number of rows updated successfully
    abstract suspend fun update(vararg instances: T):Int

    @Transaction
    @Delete
    // returns the number of rows deleted successfully
    abstract suspend fun delete(vararg instances: T):Int

    @RawQuery
    // can use SupportSQLiteQuery(interface) replace RoomRawQuery
    // use class SimpleSQLiteQuery for SupportSQLiteQuery
    // use class RoomRawQuery for RoomRawQuery
    abstract suspend fun getId(rawQuery: RoomRawQuery ): String

    suspend fun hasId( id: String, query: String):Boolean{
        return GlobalScope.async(Dispatchers.IO) {
            getId(RoomRawQuery(query))
        }.await() == id
    }

    @RawQuery
    abstract suspend fun getEntity(rawQuery: RoomRawQuery): T
}

fun String.toRawQuery() : RoomRawQuery{
    return RoomRawQuery(this)
}
