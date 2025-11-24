package com.example.pokemon.data.datasource

import com.example.pokemon.data.source.network.model.DetailPokemonResponse
import com.example.pokemon.data.source.network.service.PokemonApiService

interface DetailPokemonDataSource{
    suspend fun detailPokemon(name: String): DetailPokemonResponse
}
class DetailPokemonDataSourceImpl(private val service: PokemonApiService): DetailPokemonDataSource {
    override suspend fun detailPokemon(name: String): DetailPokemonResponse {
        return service.getDetailPokemon(name)
    }
}