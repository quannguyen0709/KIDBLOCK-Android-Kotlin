package com.example.kidlock.domain.kidlock.data


data class ParentUser(
    var id: String = "",
    var name: String = "",
    var gmail: String = "",
    var phone: String = "",
    var passWord: String = "",
    var PIN: Int = 0,
    var managerKidOfParentUser: Array<KidUserInfor> = arrayOf<KidUserInfor>(),
    )