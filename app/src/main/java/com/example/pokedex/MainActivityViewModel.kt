package com.example.pokedex

import androidx.lifecycle.ViewModel
import com.example.pokedex.data.PokemonRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class MainActivityViewModel @Inject constructor(
    private val repository: PokemonRepository
):ViewModel() {
    suspend fun read():String {
        return repository.readAll()
    }
}