package com.keepcoding.marvelapp.domain

import com.keepcoding.marvelapp.domain.model.Comic
import com.keepcoding.marvelapp.domain.model.Hero
import com.keepcoding.marvelapp.domain.model.HeroDetail
import com.keepcoding.marvelapp.domain.model.Serie
import kotlinx.coroutines.flow.Flow

interface Repository {
    suspend fun getHeros(): Flow<List<Hero>>
    suspend fun getHeroDetail(id: Int): Flow<HeroDetail>
    suspend fun getHeroSeries(id: Int): Flow<List<Serie>>
    suspend fun getHeroComics(id: Int): Flow<List<Comic>>
    suspend fun toggleFavourite(hero: Hero)
}
