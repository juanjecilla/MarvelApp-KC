package com.keepcoding.marvelapp.data.mappers

import com.keepcoding.marvelapp.data.repository.local.model.LocalHero
import com.keepcoding.marvelapp.domain.model.Hero
import javax.inject.Inject

class LocalPresentationMapper @Inject constructor() {
    fun mapHeros(heroList: List<LocalHero>): List<Hero> {
        return heroList.map { map(it) }
    }

    fun map(hero: LocalHero): Hero {
        return Hero(hero.id, hero.name, hero.photo, hero.favorite)
    }
}
