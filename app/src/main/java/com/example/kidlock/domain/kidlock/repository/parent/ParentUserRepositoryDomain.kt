package com.example.kidlock.domain.kidlock.repository.parent

import com.example.kidlock.domain.kidlock.data.ParentUser
import com.example.kidlock.utils.generic.RepositoryGeneric
import com.example.kidlock.utils.resource.Resource

interface ParentUserRepositoryDomain{
   public suspend fun createParentUser(instance: ParentUser): Resource<ParentUser>
   public suspend fun updateParentUser(instance: ParentUser): Resource<ParentUser>
   public suspend fun deleteParentUser(instance: ParentUser):Resource<ParentUser>
}