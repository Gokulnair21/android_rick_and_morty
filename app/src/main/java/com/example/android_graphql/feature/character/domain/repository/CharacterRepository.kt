package com.example.android_graphql.feature.character.domain.repository

import com.apollographql.apollo3.api.ApolloResponse
import com.example.android_graphql.CharactersQuery

interface CharacterRepository {

    suspend fun getCharacterList(): ApolloResponse<CharactersQuery.Data>

}