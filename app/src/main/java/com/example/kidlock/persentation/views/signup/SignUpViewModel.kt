package com.example.kidlock.persentation.views.signup

import androidx.compose.ui.focus.FocusManager
import androidx.compose.ui.platform.LocalFocusManager
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.kidlock.persentation.views.signup.compose.EmailUser
import com.example.kidlock.persentation.views.signup.compose.NameUser
import com.example.kidlock.persentation.views.signup.compose.PasswordUser
import com.example.kidlock.persentation.views.signup.compose.RepeatPasswordUser
import com.example.kidlock.persentation.views.signup.compose.TypeInput
import com.example.kidlock.persentation.views.signup.compose.TypeTextInputVaild
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class SignUpViewModel @Inject constructor(): ViewModel(){
    lateinit var listInforSignUp : Map<TypeInput, TypeTextInputVaild>

    init {
        setValueOfListInforSignUp()
    }

    fun setValueOfListInforSignUp() {
        listInforSignUp = mapOf(
            TypeInput.NAME_USE to NameUser(),
            TypeInput.EMAIL_USER to EmailUser(),
            TypeInput.PASSWORD_USER to PasswordUser(),
            TypeInput.REPEAT_PASSWORD_USER to RepeatPasswordUser()
        )
        setCofig()
    }

    fun setCofig(){
        listInforSignUp.get(TypeInput.PASSWORD_USER)!!.input.observeForever(Observer<String>{
                it ->
            (listInforSignUp.get(TypeInput.REPEAT_PASSWORD_USER)!! as RepeatPasswordUser).passwordUser = it
        })
    }




}