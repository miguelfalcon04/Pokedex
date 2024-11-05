package com.example.pokedex.data.remote

import com.example.pokedex.data.Pokemon
import kotlinx.coroutines.flow.Flow
import retrofit2.Response
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class PokemonNetworkDataSource
    @Inject constructor(
        private val pokeApi: PokeApi
    ):PokemonRemoteDataSource
{
    override suspend fun readAll(): Response<PokemonListRawResponse> {
        return pokeApi.read();
    }

    override suspend fun readOne(id: Int): Response<Pokemon> {
        return pokeApi.readOne(id)

    }

    override suspend fun observeAll(): Flow<List<Pokemon>> {
        TODO("Not yet implemented")
    }

}