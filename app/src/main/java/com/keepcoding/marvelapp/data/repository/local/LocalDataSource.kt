package com.keepcoding.marvelapp.data.repository.local

import com.keepcoding.marvelapp.data.repository.local.model.LocalHero
import kotlinx.coroutines.flow.Flow

interface LocalDataSource {
    fun getHeros(): Flow<List<LocalHero>>
    fun insertHeros(heros: List<LocalHero>)
}
