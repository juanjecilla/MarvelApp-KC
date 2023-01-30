package com.keepcoding.marvelapp.data.repository.remote.responses

import com.squareup.moshi.Json

data class NetworkThumbnailData(

    @Json(name = "path")
    val path: String,

    @Json(name = "extension")
    val extension: String
)
