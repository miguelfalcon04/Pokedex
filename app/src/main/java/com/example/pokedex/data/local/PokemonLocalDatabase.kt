package com.example.pokedex.data.local

import com.example.pokedex.data.Pokemon
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class PokemonLocalDatabase
@Inject constructor(
    private val dao: PokemonDao
):PokemonLocalDataSource {


    override suspend fun insert(pokemons: List<Pokemon>) {
       return dao.create(pokemons.toLocal())
    }

    override suspend fun readAll(): List<Pokemon> {
       return dao.readAll().toExternal()
    }

    override fun observeAll(): Flow<List<Pokemon>> {
        return dao.observeAll().map {
            localPokemons -> localPokemons.toExternal()
        }
    }

}