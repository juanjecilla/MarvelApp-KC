package com.keepcoding.marvelapp.data.repository.remote

import com.keepcoding.marvelapp.data.repository.remote.responses.NetworkComic
import com.keepcoding.marvelapp.data.repository.remote.responses.NetworkHero
import com.keepcoding.marvelapp.data.repository.remote.responses.NetworkHeroDetail
import com.keepcoding.marvelapp.data.repository.remote.responses.NetworkSerie
import kotlinx.coroutines.flow.Flow

interface RemoteDataSource {
    suspend fun getCharacters(limit: Int, offset: Int): List<NetworkHero>
    suspend fun getCharacter(id: Int): Flow<NetworkHeroDetail>
    suspend fun getCharacterComics(id: Int): Flow<List<NetworkComic>>
    suspend fun getCharacterSeries(id: Int): Flow<List<NetworkSerie>>
}
