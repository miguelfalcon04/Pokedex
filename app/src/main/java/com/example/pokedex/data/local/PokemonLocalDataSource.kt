package com.example.pokedex.data.local

import com.example.pokedex.data.Pokemon
import kotlinx.coroutines.flow.Flow

interface PokemonLocalDataSource {

    suspend fun insert(pokemons: List<Pokemon>)
    suspend fun readAll():List<Pokemon>
    fun observeAll(): Flow<List<Pokemon>>

}