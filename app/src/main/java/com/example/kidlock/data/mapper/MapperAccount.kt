package com.example.kidlock.data.mapper

import com.example.kidlock.domain.kidlock.data.AccountUser


fun AccountEntities.toAccountUser(): AccountUser {
    return AccountUser(
        name = name,
        email = email,
        passWord = passWord,
        pin = pin
    )
}

fun AccountUser.toAccountEntities( ): AccountEntities{
    return AccountEntities(
        name = name,
        email =  email,
        passWord =  passWord,
        pin = pin
    )
}