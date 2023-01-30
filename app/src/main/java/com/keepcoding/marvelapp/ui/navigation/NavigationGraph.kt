package com.keepcoding.marvelapp.ui.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.keepcoding.marvelapp.ui.detail.HeroDetailScreen
import com.keepcoding.marvelapp.ui.herolist.HeroScreen

@Composable
fun NavigationGraph() {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = "") {
        composable(AppScreens.HeroListScreen.route) {
            HeroScreen() {
                navController.navigate(AppScreens.HeroDetailScreen.getRoute(it))
            }
        }

        composable(AppScreens.HeroDetailScreen.route) {
            HeroDetailScreen()
        }
    }
}
