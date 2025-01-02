package com.example.kidlock.persentation.views.dashboard

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.kidlock.domain.kidlock.data.ParentUser
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class DashboardViewModel @Inject constructor() : ViewModel() {

    val result = MutableLiveData<ParentUser>(ParentUser())
}