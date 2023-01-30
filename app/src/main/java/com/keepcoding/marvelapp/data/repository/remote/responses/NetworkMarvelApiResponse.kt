package com.keepcoding.marvelapp.data.repository.remote.responses

import com.squareup.moshi.Json

data class NetworkMarvelApiResponse(
    @Json(name = "code") val code: Int,
    @Json(name = "data") val data: NetworkResultData,
)
