package com.keepcoding.marvelapp.ui.detail

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel
import coil.compose.rememberAsyncImagePainter
import com.keepcoding.marvelapp.domain.model.HeroDetail
import com.keepcoding.marvelapp.ui.commons.Mocks

@Composable
fun HeroDetailScreen(heroDetailViewModel: HeroDetailViewModel = hiltViewModel()) {
    val state by heroDetailViewModel.state.collectAsState()
    HeroDetailContent(state.hero)
}

@Composable
fun HeroDetailContent(heroDetail: HeroDetail) {
    Column {
        Image(painter = rememberAsyncImagePainter(model = heroDetail.photo),
            contentDescription = heroDetail.name)
        Text(text = heroDetail.name, style = MaterialTheme.typography.h5)
    }
}

@Preview(showBackground = true)
@Composable
fun HeroDetailContent_Preview() {
    HeroDetailContent(Mocks.getHeroDetail())
}
