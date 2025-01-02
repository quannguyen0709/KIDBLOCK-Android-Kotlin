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
import com.example.kidlock.persentation.views.signup.compose.TypeTextInputVaild
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class SignUpViewModel @Inject constructor(): ViewModel(){
    lateinit var listInforSignUp : Map<String, TypeTextInputVaild>

    fun setValueOfListInforSignUp(
        focusManagerName: FocusManager,
        focusManagerEmail: FocusManager,
        focusManagerPassword: FocusManager,
        focusManagerRepeat: FocusManager
    ) {

        listInforSignUp = mapOf(
            "nameUser" to NameUser(focusManager = focusManagerName),
            "emailUser" to EmailUser(focusManager = focusManagerEmail),
            "passwordUser" to PasswordUser(focusManager = focusManagerPassword,),
            "repatePasswordUser" to RepeatPasswordUser(focusManager = focusManagerRepeat)
        )
        setCofig()
    }

    fun setCofig(){
        listInforSignUp.get("passwordUser")!!.input.observeForever(Observer<String>{
                it ->
            (listInforSignUp.get("repatePasswordUser")!! as RepeatPasswordUser).passwordUser = it
            (listInforSignUp.get("repatePasswordUser")!! as RepeatPasswordUser).checkVaild()
        })
    }




}