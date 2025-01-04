package com.example.kidlock.persentation.views.dashboard

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.kidlock.domain.kidlock.data.ParentUser
import dagger.hilt.android.lifecycle.HiltViewModel
import java.util.UUID
import javax.inject.Inject

@HiltViewModel
class DashboardViewModel @Inject constructor() : ViewModel() {

    val parentUser = MutableLiveData<ParentUser>(ParentUser())

    var testMock = ParentUser(
        id = UUID.randomUUID().toString(),
        name = "TienSy",
        phone = "0906192477",
        gmail = "quangquan21102002@gmail.com",
        PIN = 123456,
        passWord = "mithot123456",
        managerKidOfParentUser = arrayOf()
    )
}