package com.example.kidlock.persentation.views.kiddevice

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.kidlock.domain.model.KidUserInfor
import com.example.kidlock.domain.model.StateModeKidDevice
import com.example.kidlock.persentation.views.kiddevice.viewcompose.StateModeScreen
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class KidDeviceViewModel @Inject constructor(): ViewModel() {
    lateinit var kidUserInfor: KidUserInfor
    lateinit var modeKidDevice: MutableLiveData<StateModeScreen>

    init {

    }

    fun setUp(){
        if (kidUserInfor != null){
            modeKidDevice =  MutableLiveData(getStateModeKidDevice())
            modeKidDevice.observeForever {
                when(it){
                    StateModeScreen.PARENT_MODE -> kidUserInfor.listDevicesByKidUser[0].stateModeKidDevice = StateModeKidDevice.PARENT.name
                    StateModeScreen.CHILD_MODE -> kidUserInfor.listDevicesByKidUser[0].stateModeKidDevice = StateModeKidDevice.CHILD.name
                    StateModeScreen.LOCK_MODE -> kidUserInfor.listDevicesByKidUser[0].stateModeKidDevice = StateModeKidDevice.LOCK.name
                }
            }
        }
    }


    fun getStateModeKidDevice(): StateModeScreen{
        return when(kidUserInfor.listDevicesByKidUser[0].stateModeKidDevice){
            StateModeKidDevice.LOCK.name -> StateModeScreen.LOCK_MODE
            StateModeKidDevice.CHILD.name -> StateModeScreen.CHILD_MODE
            StateModeKidDevice.PARENT.name -> StateModeScreen.PARENT_MODE
            else -> {
                StateModeScreen.PARENT_MODE}
        }
    }



}