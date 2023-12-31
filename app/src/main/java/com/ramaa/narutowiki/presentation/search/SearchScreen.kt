package com.ramaa.narutowiki.presentation.search

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.paging.compose.collectAsLazyPagingItems
import com.ramaa.narutowiki.domain.model.ItemCharacter
import com.ramaa.narutowiki.presentation.common.CharacterList
import com.ramaa.narutowiki.presentation.common.SearchBar
import com.ramaa.narutowiki.util.Dimens.Padding1

@Composable
fun SearchScreen(
    state: SearchState,
    event:(SearchEvent) -> Unit,
    navigateToDetails: (ItemCharacter) -> Unit
) {

    Column(
        modifier = Modifier
            .padding(top = Padding1, start = Padding1, end = Padding1)
            .statusBarsPadding()
    ) {
        SearchBar(
            text = state.searchQuery,
            readOnly = false,
            onValueChange = { event(SearchEvent.UpdateSearchQuery(it)) },
            onSearch = {
                event(SearchEvent.SearchCharacters)
            }
        )
        Spacer(modifier = Modifier.height(Padding1))
        state.characters?.let {
            val characters = it.collectAsLazyPagingItems()
            CharacterList(
                characters = characters,
                onClick = { character ->
                    navigateToDetails(character)
                }
            )
        }
    }
}