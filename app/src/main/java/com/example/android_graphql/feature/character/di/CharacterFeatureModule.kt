package com.example.android_graphql.feature.character.di

import com.apollographql.apollo3.ApolloClient
import com.example.android_graphql.feature.character.data.repository.CharacterRepositoryImpl
import com.example.android_graphql.feature.character.domain.repository.CharacterRepository
import com.example.android_graphql.feature.character.domain.use_case.CharacterListUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent


@Module
@InstallIn(ActivityComponent::class)
object CharacterFeatureModule {


    @Provides
    fun provideCharacterUseCase(characterRepository: CharacterRepository): CharacterListUseCase {
        return CharacterListUseCase(characterRepository)
    }

//    @Provides
//    fun provideCharacterRepository(apolloClient: ApolloClient): CharacterRepository {
//        return CharacterRepositoryImpl(apolloClient)
//    }

}