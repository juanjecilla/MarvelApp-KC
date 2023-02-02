package com.keepcoding.marvelapp.data.repository.local

import com.keepcoding.marvelapp.data.repository.local.model.LocalHero
import kotlinx.coroutines.flow.Flow

interface LocalDataSource {
    fun getHeros(): Flow<List<LocalHero>>
    suspend fun getHerosCount(): Int
    suspend fun insertHeros(heros: List<LocalHero>)
    suspend fun toggleFavourite(hero: LocalHero)
}
