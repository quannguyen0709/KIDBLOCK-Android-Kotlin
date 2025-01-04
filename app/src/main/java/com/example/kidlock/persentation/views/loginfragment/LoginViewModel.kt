package com.example.kidlock.persentation.views.loginfragment

import android.util.Patterns
import android.view.View
import android.view.WindowInsets
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.rememberUpdatedState
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.kidlock.data.local.parent.mapper.toEnitity
import com.example.kidlock.domain.kidlock.data.ParentUser
import com.example.kidlock.domain.kidlock.repository.parent.ParentUserRepositoryDomain
import com.example.kidlock.persentation.views.signup.compose.EmailUser
import com.example.kidlock.persentation.views.signup.compose.NameUser
import com.example.kidlock.persentation.views.signup.compose.PasswordUser
import com.example.kidlock.persentation.views.signup.compose.TypeInput
import com.example.kidlock.persentation.views.signup.compose.TypeTextInputVaild
import com.example.kidlock.uilayer.viewmodel.TestHiltClass
import com.example.kidlock.utils.mapper.Source
import com.example.kidlock.utils.mapper.Target
import com.example.kidlock.utils.mapper.mapping
import com.example.kidlock.utils.resource.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import java.util.UUID
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor(val repositoryParentUserService: ParentUserRepositoryDomain, val testing : TestHiltClass) : ViewModel() {
    val checkLoginCorrect : MutableLiveData<Boolean> = MutableLiveData<Boolean>(true)
    val typeTextInputVaild :Map<TypeInput,TypeTextInputVaild> = mapOf(
        TypeInput.EMAIL_USER to EmailUser(),
        TypeInput.PASSWORD_USER to PasswordUser()
    )
    var check : Resource<ParentUser> = Resource.Success<ParentUser>()

    val emailUserForgotPassword: EmailUser = EmailUser()

    val parentUser = ParentUser(
        id = UUID.randomUUID().toString(),
        name = "Quan",
        phone = "0906192477",
        gmail = "quangquan21102002@gmail.com",
        PIN = 123456,
        passWord = "mithot123456",
        managerKidOfParentUser = arrayOf()
    )
    fun checkValid(){
        if (typeTextInputVaild.getValue(TypeInput.EMAIL_USER).input.value!!.isNotEmpty() &&
            typeTextInputVaild.getValue(TypeInput.PASSWORD_USER).input.value!!.isNotEmpty() &&
            typeTextInputVaild.getValue(TypeInput.EMAIL_USER).vaildCheck.value == true &&
            typeTextInputVaild.getValue(TypeInput.PASSWORD_USER).vaildCheck.value == true
            ){
            checkLoginCorrect.value = true
        }else{
            typeTextInputVaild.getValue(TypeInput.EMAIL_USER).vaildCheck.value = false
            typeTextInputVaild.getValue(TypeInput.PASSWORD_USER).vaildCheck.value = false
            checkLoginCorrect.value = false
        }
    }

    suspend fun exxcuteRequestChangePassWord(): Boolean{
        delay(5000L)
        return true
    }

    suspend fun loginAccoutn() : Boolean{
        delay(10000L)
        checkValid()
        if(checkLoginCorrect.value!!) {
            createDB()
            return  true
        }else{
            return false
        }
    }


    suspend fun  createDB()  {
        val source = Source()
        val taerget = Target()
        println("TESTTTTTTTTTTTTTTTTTTTTTT: " + testing.a)
        val test = mapping(source, mapOf("name" to "like", "test" to "test"), taerget )
        println("TEST MAPPPINGNGGGGG " +test)


        val testParent = parentUser.toEnitity()
        println(testParent)



         viewModelScope.launch  (Dispatchers.IO) {
            check  = async {
                repositoryParentUserService.createParentUser(parentUser)
            }.await()
            println(check)
         }
    }

}