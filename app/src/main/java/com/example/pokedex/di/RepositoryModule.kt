package com.example.pokedex.di

import com.example.pokedex.data.DefaultPokemonRepository
import com.example.pokedex.data.PokemonRepository
import com.example.pokedex.data.local.PokemonLocalDataSource
import com.example.pokedex.data.local.PokemonLocalDatabase
import com.example.pokedex.data.remote.PokemonNetworkDataSource
import com.example.pokedex.data.remote.PokemonRemoteDataSource
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {

    @Singleton
    @Binds
    abstract fun bindPokemonRepository(repository: DefaultPokemonRepository): PokemonRepository

    @Singleton
    @Binds
    abstract fun bindPokemonRemote(remote: PokemonNetworkDataSource): PokemonRemoteDataSource

    @Binds
    @Singleton
    abstract fun bindLocalDataSource(localDataSource: PokemonLocalDatabase): PokemonLocalDataSource
}