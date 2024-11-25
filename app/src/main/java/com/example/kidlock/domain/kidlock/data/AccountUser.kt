package com.example.kidlock.domain.kidlock.data

data class AccountUser(
    val email: String,
    val passWord: String,
    var name: String,
    val pin: String
)