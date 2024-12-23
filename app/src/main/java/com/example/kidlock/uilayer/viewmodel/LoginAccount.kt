package com.example.kidlock.uilayer.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.kidlock.data.local.parent.entity.ParentUserEntity
import com.example.kidlock.data.local.parent.mapper.toEnitity
import com.example.kidlock.data.repository.parent.ParentRepositoryData
import com.example.kidlock.domain.kidlock.data.ParentUser
import com.example.kidlock.utils.mapper.Source
import com.example.kidlock.utils.mapper.Target
import com.example.kidlock.utils.mapper.mapping
import com.example.kidlock.utils.resource.Resource
import com.example.kidlock.utils.resource.executeAsynchronous
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.launch
import java.util.UUID
import javax.inject.Inject
import kotlin.reflect.full.createInstance

@HiltViewModel
class LoginAccount @Inject constructor(val repositoryData: ParentRepositoryData) : ViewModel() {
    var check : Resource<ParentUser> = Resource.Success<ParentUser>()
    fun  createDB()  {
        val source = Source()
        val taerget = Target()
        val test = mapping(source, mapOf("name" to "like", "test" to "test"), taerget )
        println("TEST MAPPPINGNGGGGG " +test)

        val parentUser = ParentUser(
            id = UUID.randomUUID().toString(),
            name = "Quan",
            phone = "0906192477",
            gmail = "quangquan21102002@gmail.com",
            PIN = 123456,
            passWord = "mithot123456",
            managerKidOfParentUser = arrayOf()
        )
        val testParent = parentUser.toEnitity()
        println(testParent)

         viewModelScope.launch  (Dispatchers.IO) {
            check  = async {
                executeAsynchronous<ParentUser>(message = "INSERT Parent User", data = null, callBack = suspend {
                    repositoryData.submit(parentUser)
                })
            }.await()
            println(check)
         }
    }

}