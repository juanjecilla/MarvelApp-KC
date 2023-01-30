package com.keepcoding.marvelapp.ui.detail

import com.keepcoding.marvelapp.domain.model.HeroDetail

data class HeroDetailState(
    val hero: HeroDetail = HeroDetail(0, "", "", "", 0, 0, false),
)
