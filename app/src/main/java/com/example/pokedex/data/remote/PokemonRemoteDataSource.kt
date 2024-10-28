package com.example.pokedex.data.remote

import com.example.pokedex.data.Pokemon
import retrofit2.Response

interface PokemonRemoteDataSource {

    suspend fun readAll(): Response<PokemonListRawResponse>
    suspend fun readOne(id: Int): Response<Pokemon>
}