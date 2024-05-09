package com.example.pawsconnect.data


data class Pet(
    val id: Int,
    val name: String,
    val specie: String,
    val age: Int,
    val location: String,
    val rating: Float,
    val isFavourite: Boolean,
    val attributes: List<String>,
    val image: String
)
