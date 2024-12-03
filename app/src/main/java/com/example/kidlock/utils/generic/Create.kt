package com.example.kidlock.utils.generic

import com.example.kidlock.utils.resource.Resource

interface Create<T> {
      suspend fun submit (instance: T);
}