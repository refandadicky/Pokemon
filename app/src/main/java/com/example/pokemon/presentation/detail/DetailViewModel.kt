package com.example.pokemon.presentation.detail

import android.os.Bundle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import com.example.pokemon.data.model.pokemon.Pokemon
import com.example.pokemon.data.repository.DetailPokemonRepository
import kotlinx.coroutines.Dispatchers

class DetailViewModel(
    private val extras: Bundle?,
    private val detailRepository: DetailPokemonRepository
) : ViewModel() {
    val pokemon = extras?.getParcelable<Pokemon>(DetailFragment.EXTRAS_POKEMON)
    fun getDetail(name: String) = detailRepository.getDetailPokemon(name).asLiveData(Dispatchers.IO)
}
