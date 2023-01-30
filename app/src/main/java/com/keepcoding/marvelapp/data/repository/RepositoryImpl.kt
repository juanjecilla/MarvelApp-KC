package com.keepcoding.marvelapp.data.repository

import com.keepcoding.marvelapp.data.mappers.DataEntityMapper
import com.keepcoding.marvelapp.data.repository.local.LocalDataSource
import com.keepcoding.marvelapp.data.repository.remote.RemoteDataSource
import com.keepcoding.marvelapp.domain.Repository
import com.keepcoding.marvelapp.domain.model.Comic
import com.keepcoding.marvelapp.domain.model.Hero
import com.keepcoding.marvelapp.domain.model.HeroDetail
import com.keepcoding.marvelapp.domain.model.Serie
import kotlinx.coroutines.flow.Flow

class RepositoryImpl(
    private val remote: RemoteDataSource,
    private val local: LocalDataSource,
    private val mapper: DataEntityMapper
) : Repository {
    override fun getHeros(): Flow<List<Hero>> {
        TODO("Not yet implemented")
    }

    override fun getHeroDetail(id: Int): Flow<HeroDetail> {
        TODO("Not yet implemented")
    }

    override fun getHeroSeries(id: Int): Flow<List<Serie>> {
        TODO("Not yet implemented")
    }

    override fun getHeroComics(id: Int): Flow<List<Comic>> {
        TODO("Not yet implemented")
    }

}
