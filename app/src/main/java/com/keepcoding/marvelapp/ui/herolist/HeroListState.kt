package com.keepcoding.marvelapp.ui.herolist

import com.keepcoding.marvelapp.domain.model.Hero

sealed class HeroListState {
    data object Loading : HeroListState()
    class Content(val heros: List<Hero>) : HeroListState()
    class Error(val message: String) : HeroListState()
}
