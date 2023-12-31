package com.ramaa.narutowiki.domain.usecases.characters

import com.ramaa.narutowiki.data.local.CharactersDao
import com.ramaa.narutowiki.domain.model.ItemCharacter
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetSavedCharacters @Inject constructor(
    private val charactersDao: CharactersDao
) {

    operator fun invoke(): Flow<List<ItemCharacter>> {
        return charactersDao.getCharacters()
    }
}