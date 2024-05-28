package com.keepcoding.marvelapp.ui.detail

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.keepcoding.marvelapp.domain.Repository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.combine
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
            combine(
                repository.getHeroDetail(id),
                repository.getHeroSeries(id),
                repository.getHeroComics(id)
            ) { detail, series, comics ->
                _state.update { state ->
                    state.copy(
                        hero = detail,
                        series = series,
                        comics = comics
                    )
                }
            }.flowOn(dispatcher).collect {}
        }
    }
}
