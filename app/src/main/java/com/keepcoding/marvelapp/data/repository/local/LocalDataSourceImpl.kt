package com.keepcoding.marvelapp.data.repository.local

import com.keepcoding.marvelapp.data.repository.local.model.LocalHero
import kotlinx.coroutines.flow.Flow

class LocalDataSourceImpl(private val dao: MarvelDAO) : LocalDataSource {
    override fun getHeros(): Flow<List<LocalHero>> {
        TODO("Not yet implemented")
    }

    override fun insertHeros(heros: List<LocalHero>) {
        TODO("Not yet implemented")
    }
}
