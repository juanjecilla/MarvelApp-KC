package com.keepcoding.marvelapp.ui.detail

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
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
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import coil.compose.rememberAsyncImagePainter
import com.keepcoding.marvelapp.R
import com.keepcoding.marvelapp.domain.model.Comic
import com.keepcoding.marvelapp.domain.model.HeroDetail
import com.keepcoding.marvelapp.domain.model.Serie
import com.keepcoding.marvelapp.ui.commons.Mocks
import com.keepcoding.marvelapp.ui.commons.components.SectionHeader
import com.keepcoding.marvelapp.ui.theme.HalfPadding
import com.keepcoding.marvelapp.ui.theme.NormalPadding

@Composable
fun HeroDetailScreen(id: Int, heroDetailViewModel: HeroDetailViewModel) {
    val state by heroDetailViewModel.state.collectAsState()

    LaunchedEffect(key1 = id) {
        heroDetailViewModel.getHeroDetail(id)
    }

    HeroDetailContent(state.hero, state.comics, state.series)
}

@Composable
private fun HeroDetailContent(heroDetail: HeroDetail, comics: List<Comic>, series: List<Serie>) {
    val context = LocalContext.current

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
                .fillMaxWidth()
                .padding(NormalPadding),
            textAlign = TextAlign.Center
        )

        SectionHeader(text = context.getString(R.string.description_label))

        Text(
            text = heroDetail.description.ifEmpty { context.getString(R.string.no_description) },
            style = MaterialTheme.typography.body1,
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = NormalPadding)
        )

        ComicsSwimlane(comics = comics)

        SeriesSwimlane(series = series)
    }
}

@Composable
private fun ComicsSwimlane(comics: List<Comic>) {
    Column() {
        val context = LocalContext.current

        SectionHeader(text = context.getString(R.string.comics_label))
        LazyRow(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(NormalPadding),
            contentPadding = PaddingValues(horizontal = NormalPadding)
        ) {
            items(comics, key = { it.id }) {
                SwimlaneItem(
                    title = it.title,
                    subtitle = context.getString(R.string.page_count_placeholder)
                        .format(it.pageCount),
                    photo = it.photo
                )
            }
        }
    }
}

@Composable
private fun SeriesSwimlane(series: List<Serie>) {
    Column {
        val context = LocalContext.current

        SectionHeader(text = context.getString(R.string.series_label))

        LazyRow(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(NormalPadding),
            contentPadding = PaddingValues(horizontal = NormalPadding)
        ) {
            items(series, key = { it.id }) {
                SwimlaneItem(
                    title = it.title,
                    subtitle = "${it.startYear}-${it.endYear}",
                    photo = it.photo
                )
            }
        }
    }
}

@Composable
private fun SwimlaneItem(
    title: String,
    subtitle: String,
    photo: String,
    modifier: Modifier = Modifier
) {
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

            Column(modifier = Modifier.width(150.dp)) {
                Text(
                    text = title,
                    style = MaterialTheme.typography.h6,
                    maxLines = 2,
                    overflow = TextOverflow.Ellipsis
                )

                Text(
                    text = subtitle,
                    style = MaterialTheme.typography.subtitle1,
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun HeroDetailContent_Preview() {
    HeroDetailContent(Mocks.getHeroDetail(), Mocks.getComics(), Mocks.getSeries())
}
