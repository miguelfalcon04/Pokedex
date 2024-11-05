package com.example.pokedex.data.local

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "pokemon")
data class PokemonEntity (
   @PrimaryKey val id: Int,
               val name : String,
               val height: Int,
               val weight: Int,
)