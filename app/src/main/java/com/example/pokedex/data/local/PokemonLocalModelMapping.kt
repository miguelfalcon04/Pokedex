package com.example.pokedex.data.local

import com.example.pokedex.data.Pokemon

fun Pokemon.toLocal():PokemonEntity{
    return PokemonEntity(
        id = this.id,
        name = this.name,
        height = this.height,
        weight = this.weight
    )

}
// Cada Elemento de tipo p (Pokemon) lo convierto a local
fun List<Pokemon>.toLocal():List<PokemonEntity>{
    return this.map { p -> p.toLocal() }
}

fun PokemonEntity.toExternal():Pokemon{
    return Pokemon(
        id = this.id,
        name = this.name,
        height = this.height,
        weight = this.weight
    )
}

// Igual que toLocal pero escrito de forma distinta
fun List<PokemonEntity>.toExternal() = map(PokemonEntity::toExternal)