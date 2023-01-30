package com.keepcoding.marvelapp.data.repository.remote

import com.keepcoding.marvelapp.data.repository.remote.responses.NetworkComic
import com.keepcoding.marvelapp.data.repository.remote.responses.NetworkMarvelCharacter
import com.keepcoding.marvelapp.data.repository.remote.responses.NetworkSerie
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException

class RemoteDataSourceImpl(private val mApi: MarvelApi) : RemoteDataSource {
    override suspend fun getCharacters(limit: Int, offset: Int): List<NetworkMarvelCharacter> {
        TODO("Not yet implemented")
    }

    override suspend fun getCharacter(id: Int): NetworkMarvelCharacter {
        TODO("Not yet implemented")
    }

    override suspend fun getCharacterComics(id: Int): Flow<List<NetworkComic>> {
        TODO("Not yet implemented")
    }

    override suspend fun getCharacterSeries(id: Int): Flow<List<NetworkSerie>> {
        TODO("Not yet implemented")
    }

}
