package com.example.kidlock.uilayer.viewmodel

import androidx.lifecycle.ViewModel
import com.example.kidlock.domain.repository.AccountRepositoryInterface
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class CreateAccount @Inject constructor(private val accountRepository: AccountRepositoryInterface) :
    ViewModel() {

}