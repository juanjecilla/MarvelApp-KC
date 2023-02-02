package com.keepcoding.marvelapp.data.mappers

import com.keepcoding.marvelapp.data.repository.local.model.LocalHero
import com.keepcoding.marvelapp.domain.model.Hero
import javax.inject.Inject

class PresentationLocalMapper @Inject constructor(){
    fun map(hero: Hero): LocalHero {
        return LocalHero(hero.id, hero.name, hero.photo, hero.favorite)
    }

}
