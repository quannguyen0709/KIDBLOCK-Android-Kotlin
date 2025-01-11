package com.example.kidlock.persentation.views.dashboard

import android.os.Build
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.kidlock.R
import com.example.kidlock.domain.model.Block
import com.example.kidlock.domain.model.DeviceInfor
import com.example.kidlock.domain.model.HistoryActivityOfDevice
import com.example.kidlock.domain.model.KidUserInfor
import com.example.kidlock.domain.model.ParentUser
import com.example.kidlock.domain.model.StateModeKidDevice
import com.example.kidlock.domain.model.TypeBlock
import dagger.hilt.android.lifecycle.HiltViewModel
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter
import java.util.Date
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


    val block: ArrayList<Block> = arrayListOf<Block>(
        Block(
            typeBlock = TypeBlock.Website.name,
            inforBlock = "facebock.com.vn",
            image = ""
        ),
        Block(
            typeBlock = TypeBlock.Website.name,
            inforBlock = "youtube.com.vn",
            image = ""
        ),
        Block(
            typeBlock = TypeBlock.Website.name,
            inforBlock = "instagram.com.vn",
            image = ""
        ),
        Block(
            typeBlock = TypeBlock.App.name,
            inforBlock = "telegram.com.vn",
            image = ""
        ),
        Block(
            typeBlock = TypeBlock.App.name,
            inforBlock = "facebook",
            image = ""
        ),
        Block(
            typeBlock = TypeBlock.App.name,
            inforBlock = "instagram",
            image = ""
        ),
        Block(
            typeBlock = TypeBlock.App.name,
            inforBlock = "telegram",
            image = ""
        )
    )
    val dateFormat = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm")


    var deviceInfor: ArrayList<DeviceInfor> = arrayListOf(
        DeviceInfor(
            idDevices = Build.ID + Build.USER,
            nameDevice = Build.MODEL,
            listBlok = block,
            stateModeKidDevice = StateModeKidDevice.CHILD.name,
            emailParentUser = "quangquan21102002@gmail.com"
        ),
    )

    var historyOfDevice = arrayListOf(
        HistoryActivityOfDevice(
            deviceInfor = deviceInfor.get(0),
            block = block.get(0),
            timeActivityOfDevice = LocalDateTime.parse("2024-12-23 13:12", DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm")).format(dateFormat)
        )
    )


    var testMockKidlist = KidUserInfor(
     id = UUID.randomUUID().toString(),
    name =  "Jane",
    age = 10,
    avatar = R.drawable.ellipse_6.toString(),
    historyActivityOfKidOnDevices = historyOfDevice,
    listDevicesByKidUser = deviceInfor,
    listBlock = block
    )

    val listKidInfor = listOf(
        testMockKidlist,
        testMockKidlist,
        testMockKidlist
    )

}