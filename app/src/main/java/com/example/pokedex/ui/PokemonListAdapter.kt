package com.example.pokedex.ui

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.pokedex.data.Pokemon
import com.example.pokedex.databinding.ActivityPokemonBinding

class PokemonListAdapter: ListAdapter<Pokemon, PokemonListAdapter.PokemonViewholder>(PokemonComparer) {

    inner class PokemonViewholder(
        private val binding: ActivityPokemonBinding
    ): RecyclerView.ViewHolder(binding.root) {

        @SuppressLint("SetTextI18n")
        fun bind(pokemon: Pokemon) {
            binding.pokemonId.text = ("ID: " + pokemon.id.toString())
            binding.pokemonName.text = pokemon.name.replaceFirstChar { it.uppercase() }
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PokemonViewholder {
        val binding = ActivityPokemonBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return PokemonViewholder(binding);
    }

    override fun onBindViewHolder(holder: PokemonViewholder, position: Int) {
        val pokemon = getItem(position)
        holder.bind(pokemon)
    }

    object PokemonComparer: DiffUtil.ItemCallback<Pokemon>() {

        override fun areItemsTheSame(oldItem: Pokemon, newItem: Pokemon): Boolean = oldItem.id == newItem.id

        override fun areContentsTheSame(oldItem: Pokemon, newItem: Pokemon): Boolean =
            oldItem.name == newItem.name
                    && oldItem.id == newItem.id

    }

}