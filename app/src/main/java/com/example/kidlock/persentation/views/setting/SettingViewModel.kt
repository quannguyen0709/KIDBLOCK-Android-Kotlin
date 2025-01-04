package com.example.kidlock.persentation.views.setting

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import com.example.kidlock.domain.kidlock.data.ParentUser
import com.example.kidlock.persentation.views.signup.compose.PasswordUser
import com.example.kidlock.persentation.views.signup.compose.RepeatPasswordUser
import com.example.kidlock.persentation.views.signup.compose.TypeInput
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.delay
import javax.inject.Inject


@HiltViewModel
class SettingViewModel @Inject constructor(): ViewModel() {
    val parentUser = MutableLiveData<ParentUser>(ParentUser())
    val inputPinCodeAsk = MutableLiveData("")
    val inputPinCodeChange = MutableLiveData("")
    val passWordOfForgotPincode = PasswordUser()

    val changePassword = listOf(
        PasswordUser().apply { this.nameInput = "Old password"
            this.errorDescription = "password is not correct"},
        PasswordUser().apply { this.nameInput = "New password"
            this.errorDescription = "password is not correct"},
        RepeatPasswordUser()
    )

    init {
        setCofig()
    }



    suspend fun changePassword(): Boolean{
        delay(5000L)
        return true
    }
    fun setCofig(){
        changePassword[1].input.observeForever(Observer<String>{
                it ->
            (changePassword[2] as RepeatPasswordUser).passwordUser = it
        })
    }

    fun checkValidPinCode(): Boolean{
        return this.parentUser.value!!.PIN.toString() == inputPinCodeAsk!!.value
    }
    suspend fun checkChangePinCode(type: ComposeGraph): Boolean{
        delay(5000L)
        return true
    }
}