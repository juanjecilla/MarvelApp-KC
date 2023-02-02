package com.keepcoding.marvelapp.domain.model

data class Serie(
    val id: Int,
    val title: String,
    val description: String?,
    val photo: String,
    val startYear: Int,
    val endYear: Int,
)
