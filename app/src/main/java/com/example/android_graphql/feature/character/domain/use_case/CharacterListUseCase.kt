package com.example.android_graphql.feature.character.domain.use_case

import com.example.android_graphql.base.BaseUseCase
import com.example.android_graphql.feature.character.domain.entity.CharacterEntity
import com.example.android_graphql.feature.character.domain.repository.CharacterRepository
import javax.inject.Inject

class CharacterListUseCase @Inject constructor(private val repository: CharacterRepository) :
    BaseUseCase<Unit, List<CharacterEntity>>() {

    override suspend fun execute(params: Unit): List<CharacterEntity> {
        val response = repository.getCharacterList()
        if (response.data != null && response.data!!.characters != null && !response.data!!.characters!!.results.isNullOrEmpty()) {

            return response.data!!.characters!!.results!!.map {
                it!!.let { characterData ->
                    CharacterEntity(
                        name = characterData.name ?: "NA",
                        gender = characterData.gender ?: "NA",
                        species = characterData.species ?: "NA",
                        image = characterData.image ?: "NA",
                        status = characterData.status ?: "NA",
                        type = characterData.type ?: "NA"
                    )

                }
            }
        }
        return emptyList<CharacterEntity>()
    }
}