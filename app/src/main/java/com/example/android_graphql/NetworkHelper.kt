package com.example.android_graphql

import com.apollographql.apollo3.ApolloClient

class NetworkHelper {


    fun provideApolloClient(): ApolloClient {
        return ApolloClient.Builder().serverUrl(BASE_URL).build()
    }

    companion object {
        const val BASE_URL = "https://rickandmortyapi.com/graphql"
    }
}