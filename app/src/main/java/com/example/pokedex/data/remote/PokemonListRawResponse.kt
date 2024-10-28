package com.example.pokedex.data.remote

class PokemonListRawResponse (
    val count: Int,
    val prev: String?,
    val next: String?,
    val results: List<PokemonRaw>
)