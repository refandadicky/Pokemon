package com.example.pokemon.data.repository


import com.example.pokemon.data.datasource.AllPokemonDataSource
import com.example.pokemon.data.model.pokemon.Pokemon
import com.example.pokemon.utils.ResultWrapper
import com.example.pokemon.utils.proceedFlow
import com.example.pokemon.data.mapper.toAllPokemonList
import kotlinx.coroutines.flow.Flow

interface AllPokemonRepository {
    fun getAllPokemon(): Flow<ResultWrapper<List<Pokemon>>>
}

class AllPokemonRepositoryImpl(private val dataSource: AllPokemonDataSource) : AllPokemonRepository {
    override fun getAllPokemon(): Flow<ResultWrapper<List<Pokemon>>> {
        return proceedFlow {
            dataSource.getAllPokemon().results!!.toAllPokemonList()
        }
    }
}
