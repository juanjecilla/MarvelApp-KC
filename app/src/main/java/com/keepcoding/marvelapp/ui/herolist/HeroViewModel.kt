package com.keepcoding.marvelapp.ui.herolist

import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import javax.inject.Inject

@HiltViewModel
class HeroViewModel @Inject constructor() : ViewModel() {
    private val _state = MutableStateFlow(HeroState(listOf()))
    val state: StateFlow<HeroState> get() = _state
}
