package com.keepcoding.marvelapp.data.repository.local

import com.keepcoding.marvelapp.data.repository.local.model.FavouriteUpdate
import com.keepcoding.marvelapp.data.repository.local.model.LocalHero
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class LocalDataSourceImpl @Inject constructor(private val dao: MarvelDAO) : LocalDataSource {
    override fun getHeros(): Flow<List<LocalHero>> {
        return dao.getHeros()
    }

    override suspend fun getHerosCount(): Int {
        return dao.getHerosCount()
    }

    override suspend fun insertHeros(heros: List<LocalHero>) {
        dao.insertAll(heros)
    }

    override suspend fun toggleFavourite(hero: LocalHero) {
        dao.updateFavourite(FavouriteUpdate(hero.id, hero.favorite.not()))
    }
}
