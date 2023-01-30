package com.keepcoding.marvelapp.data.repository.remote

import com.keepcoding.marvelapp.data.repository.remote.responses.NetworkComic
import com.keepcoding.marvelapp.data.repository.remote.responses.NetworkMarvelCharacter
import com.keepcoding.marvelapp.data.repository.remote.responses.NetworkSerie
import kotlinx.coroutines.flow.Flow

interface RemoteDataSource {
    suspend fun getCharacters(limit: Int, offset: Int): List<NetworkMarvelCharacter>
    suspend fun getCharacter(id: Int): NetworkMarvelCharacter
    suspend fun getCharacterComics(id: Int): Flow<List<NetworkComic>>
    suspend fun getCharacterSeries(id: Int): Flow<List<NetworkSerie>>
}
