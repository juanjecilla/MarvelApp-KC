package com.keepcoding.marvelapp.ui.navigation

import android.util.Log
import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.keepcoding.marvelapp.ui.detail.HeroDetailScreen
import com.keepcoding.marvelapp.ui.detail.HeroDetailViewModel
import com.keepcoding.marvelapp.ui.herolist.HeroScreen
import com.keepcoding.marvelapp.ui.herolist.HeroViewModel

@Composable
fun NavigationGraph(heroViewModel: HeroViewModel, heroDetailViewModel: HeroDetailViewModel) {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = AppScreens.HeroListScreen.route) {
        composable(AppScreens.HeroListScreen.route) {
            HeroScreen(heroViewModel = heroViewModel, navigateToDetail = {
                navController.navigate(AppScreens.HeroDetailScreen.getRoute(it))
            })
        }

        composable(
            AppScreens.HeroDetailScreen.route,
            arguments = listOf(navArgument(AppScreens.HeroDetailScreen.ARG_ID) {
                type = NavType.IntType
                nullable = false
            })
        ) { backStackEntry ->
            backStackEntry.arguments?.getInt(AppScreens.HeroDetailScreen.ARG_ID)
                ?.let { id -> HeroDetailScreen(id = id, heroDetailViewModel = heroDetailViewModel) }
        }
    }
}
