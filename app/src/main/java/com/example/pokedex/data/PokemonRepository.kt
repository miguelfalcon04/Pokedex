package com.example.pokedex.data

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.StateFlow

interface PokemonRepository {
    val setStream: StateFlow<List<Pokemon>>
    suspend fun readAll(): List<Pokemon>
    suspend fun readOne(id: Int): Pokemon
    fun observeAll(): Flow<List<Pokemon>>
}