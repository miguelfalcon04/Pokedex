package com.example.pokedex.data

import com.example.pokedex.data.remote.PokemonRemoteDataSource
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class DefaultPokemonRepository
    @Inject constructor(
        private val remoteDataSource: PokemonRemoteDataSource
    ):PokemonRepository
{
    override suspend fun readAll(): String {
        val pokemons = remoteDataSource.readAll()
        return pokemons
    }

    override suspend fun readOne(): String {
        TODO("Not yet implemented")
    }
}