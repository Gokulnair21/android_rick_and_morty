package com.example.android_graphql.feature.character.presentation.character_list

import android.util.Log
import androidx.lifecycle.viewModelScope
import com.apollographql.apollo3.ApolloClient
import com.example.android_graphql.feature.character.domain.entity.CharacterEntity
import com.example.android_graphql.CharactersQuery
import com.example.android_graphql.base.BaseViewModel
import com.example.android_graphql.feature.character.domain.use_case.CharacterListUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class CharacterListViewModel @Inject constructor( val characterListUse: CharacterListUseCase) :
    BaseViewModel() {

    private val TAG = "HomeViewModel"

    val dataList = MutableStateFlow<List<CharacterEntity>>(emptyList())

    init {
        getCharacters()
    }

    private fun getCharacters() = viewModelScope.launch(Dispatchers.IO) {
        val characterList = characterListUse(Unit)
        dataList.emit(characterList)
    }

}