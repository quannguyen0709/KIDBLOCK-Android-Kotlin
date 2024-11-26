package com.example.kidlock.data.di.local

import android.content.Context
import androidx.room.Room
import com.example.kidlock.data.infrastructure.database.KidBlockDatabase
import com.example.kidlock.data.local.historyaction.dao.HistoryActionDao
import com.example.kidlock.data.local.kiddevice.dao.KidDeviceDao
import com.example.kidlock.data.local.kidinfor.dao.KidInforDao
import com.example.kidlock.data.local.parent.dao.ParentDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object DataBaseKidBlockModule {
    @Singleton
    @Provides
    fun provideRoomDataBase(@ApplicationContext applicationContext: Context): KidBlockDatabase {
        return Room.databaseBuilder(
            /* context = */ applicationContext,
            /* klass = */ KidBlockDatabase::class.java,
            /* name = */ "kidbloc-database"
        ).build()
    }


    @Singleton
    @Provides
    fun provideParentDao( database: KidBlockDatabase):ParentDao{
        return database.parentDao()
    }

    @Singleton
    @Provides
    fun provideKidInforDao( database: KidBlockDatabase):KidInforDao{
        return database.kidInforDao()
    }
    @Singleton
    @Provides
    fun provideKidDeviceDao( database: KidBlockDatabase):KidDeviceDao{
        return database.kidDeviceDao()
    }
    @Singleton
    @Provides
    fun provideHistoryActionDao( database: KidBlockDatabase):HistoryActionDao{
        return database.historyActionDao()
    }
}