package com.example.android_graphql.feature.character.domain.entity

data class CharacterEntity(
    val name: String,
    val species: String,
    val status: String,
    val type: String,
    val gender: String,
    val image: String
)