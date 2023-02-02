package com.keepcoding.marvelapp.data.repository

import com.keepcoding.marvelapp.data.mappers.LocalPresentationMapper
import com.keepcoding.marvelapp.data.mappers.NetworkLocalMapper
import com.keepcoding.marvelapp.data.mappers.NetworkPresentationMapper
import com.keepcoding.marvelapp.data.mappers.PresentationLocalMapper
import com.keepcoding.marvelapp.data.repository.local.LocalDataSource
import com.keepcoding.marvelapp.data.repository.remote.RemoteDataSource
import com.keepcoding.marvelapp.domain.Repository
import com.keepcoding.marvelapp.domain.model.Comic
import com.keepcoding.marvelapp.domain.model.Hero
import com.keepcoding.marvelapp.domain.model.HeroDetail
import com.keepcoding.marvelapp.domain.model.Serie
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class RepositoryImpl @Inject constructor(
    private val remote: RemoteDataSource,
    private val local: LocalDataSource,
    private val networkLocalMapper: NetworkLocalMapper,
    private val localPresentationMapper: LocalPresentationMapper,
    private val networkPresentationMapper: NetworkPresentationMapper,
    private val presentationLocalMapper: PresentationLocalMapper,
) : Repository {
    override suspend fun getHeros(): Flow<List<Hero>> {
        if (local.getHerosCount() == 0) {
            val remoteList = remote.getCharacters(10, 0)
            local.insertHeros(networkLocalMapper.mapHeros(remoteList))
        }
        return local.getHeros().map { localPresentationMapper.mapHeros(it) }
    }

    override suspend fun getHeroDetail(id: Int): Flow<HeroDetail> {
        return remote.getCharacter(id).map { networkPresentationMapper.map(it) }
    }

    override suspend fun getHeroSeries(id: Int): Flow<List<Serie>> {
        return remote.getCharacterSeries(id).map { networkPresentationMapper.mapSeries(it) }
    }

    override suspend fun getHeroComics(id: Int): Flow<List<Comic>> {
        return remote.getCharacterComics(id).map { networkPresentationMapper.mapComics(it) }
    }

    override suspend fun toggleFavourite(hero: Hero) {
        local.toggleFavourite(presentationLocalMapper.map(hero))
    }
}
