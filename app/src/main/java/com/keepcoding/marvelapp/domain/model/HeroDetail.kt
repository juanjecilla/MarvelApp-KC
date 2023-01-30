package com.keepcoding.marvelapp.domain.model

data class HeroDetail(
    val id: Int,
    val name: String,
    val photo: String,
    val description: String,
    val comicsCount: Int,
    val seriesCount: Int,
    val favorite: Boolean,
)
