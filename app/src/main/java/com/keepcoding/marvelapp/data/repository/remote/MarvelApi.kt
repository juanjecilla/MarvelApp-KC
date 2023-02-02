package com.keepcoding.marvelapp.data.repository.remote

import com.keepcoding.marvelapp.data.repository.remote.responses.NetworkComic
import com.keepcoding.marvelapp.data.repository.remote.responses.NetworkHero
import com.keepcoding.marvelapp.data.repository.remote.responses.NetworkHeroDetail
import com.keepcoding.marvelapp.data.repository.remote.responses.NetworkMarvelApiResponse
import com.keepcoding.marvelapp.data.repository.remote.responses.NetworkSerie
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface MarvelApi {

    @GET("/v1/public/characters")
    suspend fun getCharacters(
        @Query("limit") limit: Int,
        @Query("offset") offset: Int,
    ): NetworkMarvelApiResponse<NetworkHero>

    @GET("/v1/public/characters/{id}")
    suspend fun getCharacter(@Path("id") id: Int): NetworkMarvelApiResponse<NetworkHeroDetail>

    @GET("/v1/public/characters/{id}/comics")
    suspend fun getComics(@Path("id") id: Int): NetworkMarvelApiResponse<NetworkComic>

    @GET("/v1/public/characters/{id}/series")
    suspend fun getSeries(@Path("id") id: Int): NetworkMarvelApiResponse<NetworkSerie>
}
