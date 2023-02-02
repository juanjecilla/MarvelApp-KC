package com.keepcoding.marvelapp.data.repository.remote

import com.keepcoding.marvelapp.data.repository.remote.responses.NetworkComic
import com.keepcoding.marvelapp.data.repository.remote.responses.NetworkHero
import com.keepcoding.marvelapp.data.repository.remote.responses.NetworkHeroDetail
import com.keepcoding.marvelapp.data.repository.remote.responses.NetworkSerie
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOf
import javax.inject.Inject

class RemoteDataSourceImpl @Inject constructor(private val api: MarvelApi) : RemoteDataSource {
    override suspend fun getCharacters(limit: Int, offset: Int): List<NetworkHero> {
        return api.getCharacters(10, 0).data.results
    }

    override suspend fun getCharacter(id: Int): Flow<NetworkHeroDetail> {
        return flowOf(api.getCharacter(id).data.results.first())
    }

    override suspend fun getCharacterComics(id: Int): Flow<List<NetworkComic>> {
        return flowOf(api.getComics(id).data.results)
    }

    override suspend fun getCharacterSeries(id: Int): Flow<List<NetworkSerie>> {
        return flowOf(api.getSeries(id).data.results)
    }
}
