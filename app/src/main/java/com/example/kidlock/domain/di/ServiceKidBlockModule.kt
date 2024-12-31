package com.example.kidlock.domain.di;


import com.example.kidlock.data.repository.parent.ParentRepositoryData
import com.example.kidlock.domain.kidlock.repository.parent.ParentUserRepositoryDomain;
import com.example.kidlock.domain.kidlock.service.parent.ParentUserService

import dagger.Binds;
import dagger.Module;
import dagger.Provides;
import dagger.hilt.InstallIn;
import dagger.hilt.components.SingletonComponent;
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class ServiceKidBlockModule{

    @Singleton
    @Binds
    abstract  fun bindParentUserServiceDomain( parentUserService: ParentUserService):ParentUserRepositoryDomain
}