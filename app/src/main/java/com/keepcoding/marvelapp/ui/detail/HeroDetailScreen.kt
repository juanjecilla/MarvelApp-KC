package com.keepcoding.marvelapp.ui.detail

import android.graphics.BlendModeColorFilter
import android.widget.Space
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import coil.compose.AsyncImage
import coil.compose.rememberAsyncImagePainter
import com.keepcoding.marvelapp.R
import com.keepcoding.marvelapp.domain.model.Comic
import com.keepcoding.marvelapp.domain.model.HeroDetail
import com.keepcoding.marvelapp.domain.model.Serie
import com.keepcoding.marvelapp.ui.commons.Mocks
import com.keepcoding.marvelapp.ui.theme.HalfPadding
import com.keepcoding.marvelapp.ui.theme.NormalPadding

@Composable
fun HeroDetailScreen(id: Int, heroDetailViewModel: HeroDetailViewModel = hiltViewModel()) {
    val state by heroDetailViewModel.state.collectAsState()

    LaunchedEffect(key1 = id) {
        heroDetailViewModel.getHeroDetail(id)
    }

    HeroDetailContent(state.hero, state.comics, state.series)
}

@Composable
fun HeroDetailContent(heroDetail: HeroDetail, comics: List<Comic>, series: List<Serie>) {
    val scrollState = rememberScrollState()
    Column(Modifier.verticalScroll(scrollState)) {
        Image(
            painter = rememberAsyncImagePainter(model = heroDetail.photo),
            contentDescription = heroDetail.name,
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .fillMaxWidth()
                .height(300.dp)
        )
        Text(
            text = heroDetail.name,
            style = MaterialTheme.typography.h4,
            modifier = Modifier
                .fillMaxWidth(),
            textAlign = TextAlign.Center
        )

        ComicsSwimlane(comics = comics)

        SeriesSwimlane(series = series)
    }
}

@Composable
fun ComicsSwimlane(comics: List<Comic>) {
    Column(Modifier.padding(NormalPadding)) {
        val context = LocalContext.current

        Text(
            text = context.getString(R.string.comics_label),
            style = MaterialTheme.typography.h5,
            modifier = Modifier.padding(vertical = HalfPadding)
        )
        LazyRow(
            modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.spacedBy(
                NormalPadding
            )
        ) {
            items(comics, key = { it.id }) {
                SwimlaneItem(title = it.title, photo = it.photo)
            }
        }
    }
}

@Composable
fun SeriesSwimlane(series: List<Serie>) {
    Column(Modifier.padding(NormalPadding)) {
        val context = LocalContext.current

        Text(text = context.getString(R.string.series_label), style = MaterialTheme.typography.h5)
        LazyRow(
            modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.spacedBy(
                NormalPadding
            )
        ) {
            items(series, key = { it.id }) {
                SwimlaneItem(title = it.title, photo = it.photo, modifier = Modifier.fillMaxWidth())
            }
        }
    }
}

@Composable
fun SwimlaneItem(title: String, photo: String, modifier: Modifier = Modifier) {
    Card(Modifier.fillMaxWidth()) {
        Row {
            AsyncImage(
                modifier = modifier
                    .height(150.dp),
                model = photo,
                contentScale = ContentScale.Crop,
                placeholder = painterResource(id = R.drawable.ic_launcher_foreground),
                contentDescription = title
            )
            Spacer(modifier = Modifier.size(HalfPadding))

            Text(
                text = title,
                style = MaterialTheme.typography.h6,
                modifier = Modifier.width(150.dp),
                maxLines = 2,
                overflow = TextOverflow.Ellipsis
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun HeroDetailContent_Preview() {
    HeroDetailContent(Mocks.getHeroDetail(), Mocks.getComics(), Mocks.getSeries())
}
