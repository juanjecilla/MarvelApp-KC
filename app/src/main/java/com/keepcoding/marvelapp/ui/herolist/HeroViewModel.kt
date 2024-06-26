package com.keepcoding.marvelapp.ui.herolist

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.keepcoding.marvelapp.domain.Repository
import com.keepcoding.marvelapp.domain.model.Hero
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

@HiltViewModel
class HeroViewModel @Inject constructor(
    private val dispatcher: CoroutineDispatcher,
    private val repository: Repository,
) : ViewModel() {
    private val _state: MutableStateFlow<HeroListState> = MutableStateFlow(HeroListState.Loading)
    val state: StateFlow<HeroListState> get() = _state

    init {
        viewModelScope.launch(dispatcher) {
            repository.getHeros().flowOn(dispatcher).collect { heros ->
                _state.update { HeroListState.Content(heros) }
            }
        }
    }

    fun toggleFavourite(hero: Hero) {
        viewModelScope.launch {
            withContext(dispatcher) {
                repository.toggleFavourite(hero)
            }
        }
    }
}
