package com.example.kidlock.utils.generic

interface RepositoryGeneric<T> : Create<T>, Update<T>, Remove, ObjectType<T> {
}