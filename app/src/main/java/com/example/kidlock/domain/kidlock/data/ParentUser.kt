package com.example.kidlock.domain.kidlock.data

import dagger.hilt.android.AndroidEntryPoint

data class ParentUser(
    val idPaerntUser: String,
    val name: String,
    val gmail: String,
    val phone: String,
    val passWord: String,
    val PIN: Int,
    val managerKidOfParentUser: Array<KidUserInfor>,
    )
