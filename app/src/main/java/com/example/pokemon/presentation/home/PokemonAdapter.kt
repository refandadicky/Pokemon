package com.example.pokemon.presentation.home

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.example.pokemon.data.model.pokemon.Pokemon
import com.example.pokemon.databinding.ItemPokemonBinding

class PokemonAdapter(
    private val onClick: (Pokemon) -> Unit
) : RecyclerView.Adapter<PokemonAdapter.ViewHolder>() {

    private val items = mutableListOf<Pokemon>()

    fun submitData(data: List<Pokemon>) {
        items.clear()
        items.addAll(data)
        notifyDataSetChanged()
    }

    inner class ViewHolder(private val binding: ItemPokemonBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(item: Pokemon) {
            binding.tvName.text = item.name
            binding.ivPokemon.load(item.imgUrl)
            binding.root.setOnClickListener { onClick(item) }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            ItemPokemonBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        )
    }

    override fun getItemCount() = items.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(items[position])
    }
}
