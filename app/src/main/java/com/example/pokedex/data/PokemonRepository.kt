package com.example.pokedex.data

interface PokemonRepository {

    suspend fun readAll(): String
    suspend fun readOne(): String

}