package com.example.kidlock.domain.di;


import com.example.kidlock.domain.repository.ParentUserRepositoryDomain;

import dagger.Binds;
import dagger.Module;
import dagger.hilt.InstallIn;
import dagger.hilt.components.SingletonComponent;
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class ServiceKidBlockModule{

//    @Singleton
//    @Binds
//    abstract  fun bindParentUserServiceDomain( parentUserService: ParentUserService): ParentUserRepositoryDomain
}