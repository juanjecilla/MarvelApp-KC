package com.keepcoding.marvelapp.ui.navigation


sealed class AppScreens(val route: String) {

    object HeroListScreen : AppScreens(HERO_LIST_ROUTE)
    object HeroDetailScreen : AppScreens(HERO_DETAIL_ROUTE) {
        fun getRoute(id: Int): String {
            return HERO_DETAIL_ROUTE_PLACEHOLDER.format(id)
        }
    }

}

private const val HERO_LIST_ROUTE = "heros"
private const val HERO_DETAIL_ROUTE = "heros/{id}"
private const val HERO_DETAIL_ROUTE_PLACEHOLDER = "heros/%d"
