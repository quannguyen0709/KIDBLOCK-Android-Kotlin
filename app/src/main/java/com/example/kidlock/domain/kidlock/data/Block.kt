package com.example.kidlock.domain.kidlock.data

data class Block(
    val typeBlock: TypeBlock,
    val inforBlock: String
)

enum class TypeBlock{
    App,
    Website
}