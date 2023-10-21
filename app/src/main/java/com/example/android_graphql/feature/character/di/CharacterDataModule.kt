package com.example.android_graphql.feature.character.di

import com.example.android_graphql.feature.character.data.repository.CharacterRepositoryImpl
import com.example.android_graphql.feature.character.domain.repository.CharacterRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent
import dagger.hilt.components.SingletonComponent


@Module
@InstallIn(SingletonComponent::class)
abstract class CharacterDataModule {

    @Binds
    abstract fun provideCharacterRepository(characterRepository: CharacterRepositoryImpl): CharacterRepository
}