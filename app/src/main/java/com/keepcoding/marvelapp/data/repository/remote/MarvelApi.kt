package com.keepcoding.marvelapp.data.repository.remote

import com.keepcoding.marvelapp.data.repository.remote.responses.NetworkMarvelApiResponse
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface MarvelApi {

    @GET("/v1/public/characters")
    suspend fun getCharacters(
        @Query("limit") limit: Int,
        @Query("offset") offset: Int
    ): NetworkMarvelApiResponse

    @GET("/v1/public/characters/{id}")
    suspend fun getCharacter(@Path("id") id: Int): NetworkMarvelApiResponse
}
