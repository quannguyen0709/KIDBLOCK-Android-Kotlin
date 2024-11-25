package com.example.kidlock.domain.kidlock.repository

interface RepositoryObject<T> : Create<T>, Update<T>, Remove, ObjectType<T> {
}