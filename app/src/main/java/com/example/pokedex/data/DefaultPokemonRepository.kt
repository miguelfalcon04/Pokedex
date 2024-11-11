package com.example.pokedex.data

import com.example.pokedex.data.local.PokemonLocalDataSource
import com.example.pokedex.data.remote.PokemonRemoteDataSource
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.withContext
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class DefaultPokemonRepository
    @Inject constructor(
        private val remoteDataSource: PokemonRemoteDataSource,
        private val localDataSource: PokemonLocalDataSource
    ):PokemonRepository
{
    private val _state = MutableStateFlow<List<Pokemon>>(listOf())
    override val setStream: StateFlow<List<Pokemon>>
        get() = _state.asStateFlow()


    override suspend fun readAll(): List<Pokemon> {
        val response = remoteDataSource.readAll()
        val pokemonList = _state.value.toMutableList()
        if(response.isSuccessful){
            val pokemonRawList = response.body()!!.results
            pokemonRawList.forEach{ pkr ->
                pokemonList.add(readOne(idUrl(pkr.url)!!))
                _state.emit(pokemonList.toList())

            }
        }
        else _state.value = pokemonList

        return pokemonList
    }

    override suspend fun readOne(id: Int): Pokemon {
        val response = remoteDataSource.readOne(id)
        return if (response.isSuccessful)response.body()!!
        else Pokemon(0,"")
    }

    override fun observeAll(): Flow<List<Pokemon>> {
        refreshLocal()
        return localDataSource.observeAll()
    }

    private fun idUrl(url: String):Int?{
        return url.trimEnd('/').substringAfterLast('/').toIntOrNull()
    }

    //TODO() pokemonRemote debe devolver List<Pokemon>
    private fun refreshLocal(){
        GlobalScope.launch(Dispatchers.IO) {
            val pokemonRemote = remoteDataSource.readAll()
            // localDataSource.insert(pokemonRemote)
        }
    }
}