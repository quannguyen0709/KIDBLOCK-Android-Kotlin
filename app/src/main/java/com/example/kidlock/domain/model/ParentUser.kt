package com.example.kidlock.domain.model

import com.google.gson.annotations.SerializedName


data class ParentUser(
    @SerializedName("id")
    var id: String = "",
    @SerializedName("name")
    var name: String = "",
    @SerializedName("gmail")
    var gmail: String = "",
    @SerializedName("phone")
    var phone: String = "",
    @SerializedName("passWord")
    var passWord: String = "",
    @SerializedName("PIN")
    var PIN: Int = 0,
    @SerializedName("managerKidOfParentUser")
    var managerKidOfParentUser: Array<KidUserInfor> = arrayOf<KidUserInfor>(),
    )