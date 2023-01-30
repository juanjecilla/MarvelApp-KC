package com.keepcoding.marvelapp.ui.herolist

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel
import coil.compose.rememberAsyncImagePainter
import com.keepcoding.marvelapp.domain.model.Hero
import com.keepcoding.marvelapp.ui.commons.Mocks
import com.keepcoding.marvelapp.ui.theme.HalfPadding

@Composable
fun HeroScreen(
    heroViewModel: HeroViewModel = hiltViewModel(),
    navigateToDetail: (Int) -> (Unit),
) {
    val state by heroViewModel.state.collectAsState()
    val heroList = state.heros

    HeroScreenContent(heroList = heroList, navigateToDetail = navigateToDetail)
}

@Composable
fun HeroScreenContent(heroList: List<Hero>, navigateToDetail: (Int) -> (Unit)) {
    Box(modifier = Modifier.fillMaxSize()) {
        LazyColumn(modifier = Modifier.fillMaxSize(), contentPadding = PaddingValues(HalfPadding)) {
            items(heroList, key = { it.id }) {
                HeroItem(it, navigateToDetail)
            }
        }
    }
}

@Composable
fun HeroItem(hero: Hero, navigateToDetail: (Int) -> Unit) {
    Card(modifier = Modifier
        .fillMaxWidth()
        .clickable { navigateToDetail(hero.id) }) {
        Column(modifier = Modifier.fillMaxWidth()) {
            Image(painter = rememberAsyncImagePainter(model = hero.photo),
                contentDescription = hero.name)
            Text(hero.name, style = MaterialTheme.typography.caption)
        }
    }
}

@Preview(showBackground = true)
@Composable
fun HeroScreenContent_Preview() {
    HeroScreenContent(heroList = Mocks.getHeros(), navigateToDetail = {})
}
