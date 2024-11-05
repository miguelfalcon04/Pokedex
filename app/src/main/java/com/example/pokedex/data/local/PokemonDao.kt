package com.example.pokedex.data.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import kotlinx.coroutines.flow.Flow

@Dao
interface PokemonDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun create(pokemon:PokemonEntity)
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun create(pokemons:List<PokemonEntity>)
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun create(vararg pokemons:PokemonEntity)

    @Update
    suspend fun update(pokemon: PokemonEntity)

    @Query("SELECT * FROM pokemon")
    suspend fun readAll():List<PokemonEntity>

    @Query("SELECT * FROM pokemon")
    fun observeAll(): Flow<List<PokemonEntity>>

}