package com.keepcoding.marvelapp.ui.detail

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.keepcoding.marvelapp.domain.Repository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HeroDetailViewModel @Inject constructor(
    private val dispatcher: CoroutineDispatcher,
    private val repository: Repository,
) : ViewModel() {
    private val _state = MutableStateFlow(HeroDetailState())
    val state: StateFlow<HeroDetailState> get() = _state

    fun getHeroDetail(id: Int) {
        viewModelScope.launch {
            repository.getHeroDetail(id).flowOn(dispatcher).collect {
                _state.update { state -> state.copy(hero = it) }
            }

            repository.getHeroSeries(id).flowOn(dispatcher).collect {
                _state.update { state -> state.copy(series = it) }
            }

            repository.getHeroComics(id).flowOn(dispatcher).collect {
                _state.update { state -> state.copy(comics = it) }
            }
        }
    }
}
