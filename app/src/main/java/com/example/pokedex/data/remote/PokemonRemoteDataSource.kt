package com.example.pokedex.data.remote

interface PokemonRemoteDataSource {

    suspend fun readAll():String
    suspend fun readOne():String
}