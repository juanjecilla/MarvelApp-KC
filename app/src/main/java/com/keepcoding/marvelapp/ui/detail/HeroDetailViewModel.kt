package com.keepcoding.marvelapp.ui.detail

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HeroDetailViewModel @Inject constructor() : ViewModel() {
    private val _state = MutableStateFlow(HeroDetailState())
    val state: StateFlow<HeroDetailState> get() = _state

    fun getHeroDetail(id: Int){
        viewModelScope.launch {

        }
    }
}
