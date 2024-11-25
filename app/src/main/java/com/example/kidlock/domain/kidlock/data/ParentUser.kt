package com.example.kidlock.domain.kidlock.data

data class ParentUser(
    val name: String,
    val gmail: String,
    val phone: String,
    val passWord: String,
    val PIN: Int,
    val managerKidOfParentUser: Array<KidUserDevices>,

    )
