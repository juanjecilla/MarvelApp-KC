package com.keepcoding.marvelapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.ui.Modifier
import com.keepcoding.marvelapp.ui.detail.HeroDetailViewModel
import com.keepcoding.marvelapp.ui.herolist.HeroViewModel
import com.keepcoding.marvelapp.ui.navigation.NavigationGraph
import com.keepcoding.marvelapp.ui.theme.MyApplicationTheme
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    private val heroViewModel: HeroViewModel by viewModels()
    private val heroDetailViewModel: HeroDetailViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CompositionLocalProvider(
                androidx.lifecycle.compose.LocalLifecycleOwner provides androidx.compose.ui.platform.LocalLifecycleOwner.current,
            ) {
                AppContent(heroViewModel, heroDetailViewModel)
            }
        }
    }
}

@Composable
fun AppContent(heroViewModel: HeroViewModel, heroDetailViewModel: HeroDetailViewModel) {
    MyApplicationTheme {
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colors.background
        ) {
            NavigationGraph(heroViewModel, heroDetailViewModel)
        }
    }
}
