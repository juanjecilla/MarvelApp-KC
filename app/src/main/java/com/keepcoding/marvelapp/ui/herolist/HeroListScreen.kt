package com.keepcoding.marvelapp.ui.herolist

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Card
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.rememberVectorPainter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import coil.compose.AsyncImage
import com.keepcoding.marvelapp.R
import com.keepcoding.marvelapp.domain.model.Hero
import com.keepcoding.marvelapp.ui.commons.Mocks
import com.keepcoding.marvelapp.ui.commons.components.MarvelTopBar
import com.keepcoding.marvelapp.ui.theme.HalfPadding

@Composable
fun HeroScreen(
    heroViewModel: HeroViewModel,
    navigateToDetail: (Int) -> (Unit)
) {
    val state by heroViewModel.state.collectAsStateWithLifecycle(
        lifecycleOwner = androidx.compose.ui.platform.LocalLifecycleOwner.current
    )

    when (state) {
        is HeroListState.Content -> {
            HeroScreen_Content(
                state = state as HeroListState.Content,
                navigateToDetail = navigateToDetail,
                onFavClicked = {
                    heroViewModel.toggleFavourite(it)
                })
        }

        is HeroListState.Error -> {}
        HeroListState.Loading -> {

        }
    }


}

@Composable
private fun HeroScreen_Content(
    state: HeroListState.Content,
    navigateToDetail: (Int) -> (Unit),
    onFavClicked: (Hero) -> Unit,
) {
    Scaffold(topBar = {
        MarvelTopBar()
    }) { paddingValues ->
        Surface(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues),
            color = MaterialTheme.colors.background
        ) {
            LazyColumn(
                modifier = Modifier.fillMaxSize(),
                contentPadding = PaddingValues(HalfPadding)
            ) {
                items(state.heros, key = { it.id }) {
                    HeroItem(it, navigateToDetail, onFavClicked = onFavClicked)
                }
            }
        }
    }

}

@Composable
private fun HeroItem(hero: Hero, navigateToDetail: (Int) -> Unit, onFavClicked: (Hero) -> Unit) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(HalfPadding)
            .clickable { navigateToDetail(hero.id) },
        elevation = 8.dp
    ) {
        Box(modifier = Modifier.fillMaxWidth()) {
            Column(modifier = Modifier.fillMaxWidth()) {
                AsyncImage(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(200.dp),
                    model = hero.photo,
                    contentDescription = hero.name,
                    contentScale = ContentScale.Crop,
                    placeholder = painterResource(id = R.drawable.ic_launcher_foreground)
                )
                Text(
                    hero.name,
                    style = MaterialTheme.typography.h5,
                    modifier = Modifier.padding(
                        HalfPadding
                    )
                )
            }

            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(200.dp)
                    .background(
                        brush = Brush.linearGradient(
                            listOf(Color.Black, Color.Transparent, Color.Transparent),
                            start = Offset(Float.POSITIVE_INFINITY, 0f),
                            end = Offset(0f, Float.POSITIVE_INFINITY)
                        )
                    )
            ) {
                IconButton(
                    modifier = Modifier
                        .align(Alignment.TopEnd)
                        .padding(HalfPadding),
                    onClick = { onFavClicked(hero) }) {
                    val context = LocalContext.current
                    if (hero.favorite) {
                        Icon(
                            painter = rememberVectorPainter(Icons.Default.Favorite),
                            contentDescription = context.getString(R.string.favorite),
                            tint = Color.White
                        )
                    } else {
                        Icon(
                            painter = rememberVectorPainter(Icons.Default.FavoriteBorder),
                            contentDescription = context.getString(R.string.not_favorite),
                            tint = Color.White
                        )
                    }
                }
            }
        }

    }
}

@Preview(showBackground = true)
@Composable
private fun HeroScreenContent_Preview() {
    HeroScreen_Content(
        state = HeroListState.Content(Mocks.getHeros()),
        navigateToDetail = {},
        onFavClicked = {})
}
