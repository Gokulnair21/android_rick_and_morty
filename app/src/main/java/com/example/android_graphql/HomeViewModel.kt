package com.example.android_graphql

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.apollographql.apollo3.ApolloClient
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch

class HomeViewModel : ViewModel() {

    private val TAG = "HomeViewModel"

    val dataList = MutableStateFlow<List<CharacterEntity>>(emptyList())

    init {
        getCharacters()
    }

    private fun getCharacters() = viewModelScope.launch(Dispatchers.IO) {
        try {
            Log.e(TAG, "getCharacters: ")
            val apolloClient = ApolloClient.Builder()
                .serverUrl("https://rickandmortyapi.com/graphql")
                .build()
            val result = apolloClient.query(CharactersQuery()).execute()
            Log.e(TAG, "getCharacters: Result : $result")
            result.data?.characters?.results?.let { list ->
                val data = list.map {
                    it!!.let {
                        CharacterEntity(
                            name = it.name!!,
                            species = it.species!!,
                            status = it.status!!,
                            type = it.type!!,
                            gender = it.gender!!,
                            image = it.image!!
                        )
                    }
                }

                dataList.emit(data)

            }
            Log.e(TAG, "getCharacters: " + result.data)
        } catch (e: Exception) {
            e.printStackTrace()
        }

    }

}