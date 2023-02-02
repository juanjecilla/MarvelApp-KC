package com.keepcoding.marvelapp.ui.commons

import com.keepcoding.marvelapp.domain.model.Comic
import com.keepcoding.marvelapp.domain.model.Hero
import com.keepcoding.marvelapp.domain.model.HeroDetail
import com.keepcoding.marvelapp.domain.model.Serie

object Mocks {

    fun getHero(id: Int = 1, name: String = "Hero", photo: String = "", favorite: Boolean): Hero {
        return Hero(id, name, photo, favorite)
    }

    fun getHeros(size: Int = 10): List<Hero> {
        return (0..size).map { getHero(it, "Hero $it", "", it % 2 == 0) }
    }

    fun getHeroDetail(
        id: Int = 1,
        name: String = "Hero",
        photo: String = "",
        description: String = "Description",
        comicsCount: Int = 10,
        seriesCount: Int = 5,
        favorite: Boolean = false,
    ): HeroDetail {
        return HeroDetail(id, name, photo, description, comicsCount, seriesCount)
    }

    fun getComics(): List<Comic> {
        return listOf()
    }

    fun getSeries(): List<Serie> {
        return listOf()
    }
}
