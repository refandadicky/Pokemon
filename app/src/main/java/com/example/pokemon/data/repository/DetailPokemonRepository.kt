package com.example.pokemon.data.repository

import com.example.pokemon.data.datasource.DetailPokemonDataSource
import com.example.pokemon.data.model.detailpokemon.DetailPokemon
import com.example.pokemon.data.mapper.toDetailPokemon
import com.example.pokemon.utils.ResultWrapper
import com.example.pokemon.utils.proceedFlow
import kotlinx.coroutines.flow.Flow

interface DetailPokemonRepository {
    fun getDetailPokemon(name: String): Flow<ResultWrapper<DetailPokemon>>
}

class DetailPokemonRepositoryImpl(private val dataSource: DetailPokemonDataSource) : DetailPokemonRepository {
    override fun getDetailPokemon(name: String): Flow<ResultWrapper<DetailPokemon>> {
        return proceedFlow {
            dataSource.detailPokemon(name).toDetailPokemon()
        }
    }
}
