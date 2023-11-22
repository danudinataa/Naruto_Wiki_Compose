package com.ramaa.narutowiki.domain.usecases.characters

import androidx.paging.PagingData
import com.ramaa.narutowiki.domain.model.Character
import com.ramaa.narutowiki.domain.repository.CharacterRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetListCharacters @Inject constructor(
    private val characterRepository: CharacterRepository
) {
    operator fun invoke(): Flow<PagingData<Character>> {
        return characterRepository.getCharacter()
    }
}