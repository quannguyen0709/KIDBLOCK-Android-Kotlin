package com.example.kidlock.uilayer.viewmodel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.kidlock.domain.repository.AccountRepositoryInterface
import com.example.kidlock.domain.utils.Resource
import com.example.kidlock.uilayer.state.UserSate
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class LoginAccount @Inject constructor(private val accountRepository: AccountRepositoryInterface) :
    ViewModel() {

}