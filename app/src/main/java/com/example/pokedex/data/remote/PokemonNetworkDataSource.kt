package com.example.pokedex.data.remote

import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class PokemonNetworkDataSource
    @Inject constructor(
        private val pokemonApi: PokeApi
    ):PokemonRemoteDataSource
{
    override suspend fun readAll(): String {
        val pokemons = pokemonApi.read()
        return  pokemons
    }

    override suspend fun readOne(): String {
        TODO("Not yet implemented")
    }
}