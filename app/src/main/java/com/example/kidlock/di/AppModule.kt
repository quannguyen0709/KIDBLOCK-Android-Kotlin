package com.example.kidlock.di

import android.content.Context
import androidx.room.Room
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {
    @Singleton
    @Provides
    fun provideAccountDataBase( @ApplicationContext app: Context ):AccountDataBase
    =  Room.databaseBuilder(app, AccountDataBase::class.java, "account_database").fallbackToDestructiveMigration().build()


    @Singleton
    @Provides
    fun provideAccountDao(db: AccountDataBase):AccountDao = db.accountDao()
}