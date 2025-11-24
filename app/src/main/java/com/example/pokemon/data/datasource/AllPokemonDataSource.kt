package com.example.pokemon.data.datasource

import com.example.pokemon.data.source.network.model.AllPokemonResponse
import com.example.pokemon.data.source.network.service.PokemonApiService

interface AllPokemonDataSource {
    suspend fun getAllPokemon(): AllPokemonResponse
}

class AllPokemonDataSourceImpl(
    private val service: PokemonApiService
) : AllPokemonDataSource {

    override suspend fun getAllPokemon(): AllPokemonResponse {
        return service.getAllPokemon()
    }
}
