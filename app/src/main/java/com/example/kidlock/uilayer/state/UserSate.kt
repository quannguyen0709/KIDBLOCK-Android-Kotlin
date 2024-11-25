package com.example.kidlock.uilayer.state

import com.example.kidlock.domain.kidlock.data.AccountUser
import com.example.kidlock.domain.utils.Resource

data class UserSate (
    var userAccount: Resource<AccountUser> = Resource.Error(message = "error don't get account from database", data = null)
)