package com.keepcoding.marvelapp.data.mappers

import com.keepcoding.marvelapp.data.repository.remote.responses.NetworkComic
import com.keepcoding.marvelapp.data.repository.remote.responses.NetworkHeroDetail
import com.keepcoding.marvelapp.data.repository.remote.responses.NetworkSerie
import com.keepcoding.marvelapp.data.repository.remote.responses.mapToPhotoString
import com.keepcoding.marvelapp.domain.model.Comic
import com.keepcoding.marvelapp.domain.model.HeroDetail
import com.keepcoding.marvelapp.domain.model.Serie
import javax.inject.Inject

class NetworkPresentationMapper @Inject constructor() {
    fun map(networkHeroDetail: NetworkHeroDetail): HeroDetail {
        return HeroDetail(
            networkHeroDetail.id,
            networkHeroDetail.name,
            networkHeroDetail.thumbnail.mapToPhotoString(),
            networkHeroDetail.description,
            0, 0
        )
    }

    fun mapSeries(networkSeries: List<NetworkSerie>): List<Serie> {
        return networkSeries.map { mapSerie(it) }
    }

    private fun mapSerie(networkSeries: NetworkSerie): Serie {
        return Serie(
            networkSeries.id,
            networkSeries.title,
            networkSeries.description,
            networkSeries.thumbnail.mapToPhotoString(),
            networkSeries.startYear,
            networkSeries.endYear
        )
    }

    fun mapComics(networkComics: List<NetworkComic>): List<Comic> {
        return networkComics.map { mapComic(it) }
    }

    private fun mapComic(networkComic: NetworkComic): Comic {
        return Comic(
            networkComic.id,
            networkComic.title,
            networkComic.pageCount,
            networkComic.thumbnail.mapToPhotoString()
        )
    }
}
