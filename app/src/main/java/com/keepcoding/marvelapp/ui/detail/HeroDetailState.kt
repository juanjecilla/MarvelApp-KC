package com.keepcoding.marvelapp.ui.detail

import com.keepcoding.marvelapp.domain.model.Comic
import com.keepcoding.marvelapp.domain.model.HeroDetail
import com.keepcoding.marvelapp.domain.model.Serie

data class HeroDetailState(
    val hero: HeroDetail = HeroDetail(0, "", "", "", 0, 0),
    val comics: List<Comic> = listOf(),
    val series: List<Serie> = listOf(),
)
