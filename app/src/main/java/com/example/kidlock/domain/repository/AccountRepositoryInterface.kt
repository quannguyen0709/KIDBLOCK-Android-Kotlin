package com.example.kidlock.domain.repository

import com.example.kidlock.domain.kidlock.data.AccountUser
import com.example.kidlock.domain.utils.Resource

interface AccountRepositoryInterface {
    suspend fun getAccount(email: String, pass : String): Resource<AccountUser>
    suspend fun insertAccount(account : AccountUser)

    suspend fun  deleteAccount(account: AccountUser)
}