package com.example.kidlock.data.repository.parent

import com.example.kidlock.domain.kidlock.data.ParentUser
import com.example.kidlock.domain.kidlock.repository.Create
import com.example.kidlock.domain.kidlock.repository.ObjectType
import com.example.kidlock.domain.kidlock.repository.Remove
import com.example.kidlock.domain.kidlock.repository.Update

interface Service: Create<ParentUser>, Update<ParentUser>, Remove, ObjectType<ParentUser> {
}