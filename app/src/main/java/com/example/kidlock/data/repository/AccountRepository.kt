package com.example.kidlock.data.repository

import com.example.kidlock.data.mapper.toAccountEntities
import com.example.kidlock.data.mapper.toAccountUser
import com.example.kidlock.domain.kidlock.data.AccountUser
import com.example.kidlock.domain.repository.AccountRepositoryInterface
import com.example.kidlock.domain.utils.Resource
import javax.inject.Inject

class AccountRepository @Inject constructor(
    private val accountDao: AccountDao
): AccountRepositoryInterface {
     override suspend fun getAccount(email: String, pass: String):Resource<AccountUser> {
         val account:AccountEntities? = accountDao.getAccount(email = email, pass = pass)
         return if ( account != null ){
             Resource.Success(data = account.toAccountUser(), message = "correct")
         } else{
             Resource.Error(data = null, message = "can't get account from database")
         }
     }
    override suspend fun insertAccount(account : AccountUser) = accountDao.insertAccount(account.toAccountEntities())

   override suspend fun  deleteAccount(account: AccountUser) = accountDao.deleteAccount(account = account.toAccountEntities())

}