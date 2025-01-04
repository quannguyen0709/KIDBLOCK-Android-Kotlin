package com.example.kidlock.persentation.views.signup

import androidx.compose.ui.focus.FocusManager
import androidx.compose.ui.platform.LocalFocusManager
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.navigation.NavController
import androidx.navigation.compose.composable
import androidx.navigation.createGraph
import androidx.navigation.fragment.fragment
import com.example.kidlock.persentation.navigation.ApplicationPages
import com.example.kidlock.persentation.views.dashboard.DashboardFragment
import com.example.kidlock.persentation.views.loginfragment.LoginFragment
import com.example.kidlock.persentation.views.signup.compose.EmailUser
import com.example.kidlock.persentation.views.signup.compose.NameUser
import com.example.kidlock.persentation.views.signup.compose.PasswordUser
import com.example.kidlock.persentation.views.signup.compose.RepeatPasswordUser
import com.example.kidlock.persentation.views.signup.compose.TypeInput
import com.example.kidlock.persentation.views.signup.compose.TypeTextInputVaild
import com.example.kidlock.persentation.views.wellcomefragment.WellComeFragment
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class SignUpViewModel @Inject constructor(): ViewModel(){
    lateinit var listInforSignUp : Map<TypeInput, TypeTextInputVaild>
    val pinCode = MutableLiveData<String>("")
    val repeatPinCode = MutableLiveData<String>("")

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


    //valid in sign up
    fun checkvVaildTextInput(): Boolean{
        if(listInforSignUp.getValue(TypeInput.NAME_USE).vaildCheck.value == true &&
            listInforSignUp.getValue(TypeInput.PASSWORD_USER).vaildCheck.value == true &&
            listInforSignUp.getValue(TypeInput.EMAIL_USER).vaildCheck.value == true &&
            listInforSignUp.getValue(TypeInput.REPEAT_PASSWORD_USER).vaildCheck.value == true){
            if(
                listInforSignUp.getValue(TypeInput.NAME_USE).input.value!!.isNotEmpty() &&
                listInforSignUp.getValue(TypeInput.PASSWORD_USER).input.value!!.isNotBlank() &&
                listInforSignUp.getValue(TypeInput.EMAIL_USER).input.value!!.isNotEmpty() &&
                listInforSignUp.getValue(TypeInput.REPEAT_PASSWORD_USER).input.value!!.isNotEmpty()
            ){
                return true
            }
        }

        listInforSignUp.getValue(TypeInput.NAME_USE).vaildCheck.value = false
        listInforSignUp.getValue(TypeInput.PASSWORD_USER).vaildCheck.value = false
        listInforSignUp.getValue(TypeInput.EMAIL_USER).vaildCheck.value = false
        listInforSignUp.getValue(TypeInput.REPEAT_PASSWORD_USER).vaildCheck.value = false
        return false
    }

    //valid in pin code
    fun checkValidPincode(): Boolean{
        return  repeatPinCode.value == pinCode.value
    }



}

enum class ComposeGrap{
    VIEW_OF_SIGN_UP,
    VIEW_OF_SET_PIN_CODE,
    VIEW_OF_REPEAT_PIN_CODE
}