package com.example.android_graphql.feature.character.data.repository

import com.apollographql.apollo3.ApolloClient
import com.apollographql.apollo3.api.ApolloResponse
import com.example.android_graphql.CharactersQuery
import com.example.android_graphql.feature.character.domain.repository.CharacterRepository
import javax.inject.Inject

class CharacterRepositoryImpl @Inject constructor(private val apolloClient: ApolloClient) :
    CharacterRepository {

    override suspend fun getCharacterList(): ApolloResponse<CharactersQuery.Data> {
        return apolloClient.query(CharactersQuery()).execute()
    }


}