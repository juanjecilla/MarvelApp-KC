package com.keepcoding.marvelapp.domain

import com.keepcoding.marvelapp.domain.model.Comic
import com.keepcoding.marvelapp.domain.model.Hero
import com.keepcoding.marvelapp.domain.model.HeroDetail
import com.keepcoding.marvelapp.domain.model.Serie
import kotlinx.coroutines.flow.Flow

interface Repository {
    fun getHeros(): Flow<List<Hero>>
    fun getHeroDetail(id: Int): Flow<HeroDetail>
    fun getHeroSeries(id: Int): Flow<List<Serie>>
    fun getHeroComics(id: Int): Flow<List<Comic>>
}
