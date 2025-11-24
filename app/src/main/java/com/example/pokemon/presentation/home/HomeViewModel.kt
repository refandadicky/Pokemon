package com.example.pokemon.presentation.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import com.example.pokemon.data.repository.AllPokemonRepository
import kotlinx.coroutines.Dispatchers

class HomeViewModel(
    private val allPokemonRepository: AllPokemonRepository
) : ViewModel() {
    fun getDataAllPokemon() = allPokemonRepository.getAllPokemon().asLiveData(Dispatchers.IO)
}
