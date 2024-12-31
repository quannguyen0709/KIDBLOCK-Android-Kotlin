package com.example.kidlock.data.di

import com.example.kidlock.data.repository.parent.ParentRepositoryData
import com.example.kidlock.data.repository.parent.ParentRepositoryImpl
import com.example.kidlock.domain.kidlock.data.ParentUser
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Qualifier
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryDataKidBlockModule {

    @Binds
    @Singleton
    abstract  fun bindRepositoryParent( parentRepositoryImpl: ParentRepositoryImpl):ParentRepositoryData
}