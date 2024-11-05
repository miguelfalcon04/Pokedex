package com.example.pokedex.di

import android.content.Context
import androidx.room.Room
import com.example.pokedex.data.local.PokemonDao
import com.example.pokedex.data.local.PokemonDataBase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class LocalModule {

    @Provides
    @Singleton
    fun provideDatabase(@ApplicationContext context: Context):PokemonDataBase{
        val database = Room.databaseBuilder(
            context,
            PokemonDataBase::class.java,
            "pokemon-db"
        )
        return database.build()
    }

    @Provides
    fun provideDao(pokemonDataBase: PokemonDataBase):PokemonDao = pokemonDataBase.pokemonDao()
}
