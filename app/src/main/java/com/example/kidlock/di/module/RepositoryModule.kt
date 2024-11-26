package com.example.kidlock.di.module

import com.example.kidlock.domain.repository.AccountRepositoryInterface
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {
    @Binds
    @Singleton
    abstract fun bindsRepository (accountRepository: AccountRepository): AccountRepositoryInterface
}