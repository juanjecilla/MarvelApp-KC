package com.keepcoding.marvelapp.data.repository.remote.responses

import com.squareup.moshi.Json

data class NetworkHeroDetail(
    @Json(name = "id") val id: Int,
    @Json(name = "thumbnail") val thumbnail: NetworkThumbnailData,
    @Json(name = "name") val name: String,
    @Json(name = "description") val description: String,
)
