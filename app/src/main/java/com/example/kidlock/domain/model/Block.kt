package com.example.kidlock.domain.model

import com.google.gson.annotations.SerializedName

data class Block(
    @SerializedName("typeBlock")
    var typeBlock: String,
    @SerializedName("inforBlock")
    var inforBlock: String,
    @SerializedName("image")
    var image: String = ""
)

enum class TypeBlock{
    App,
    Website
}