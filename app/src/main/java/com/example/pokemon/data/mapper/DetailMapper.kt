package com.example.pokemon.data.mapper

import com.example.pokemon.data.model.detailpokemon.DetailPokemon
import com.example.pokemon.data.model.detailpokemon.StatPokemon
import com.example.pokemon.data.source.network.model.DetailPokemonResponse

fun DetailPokemonResponse.toDetailPokemon(): DetailPokemon {
    return DetailPokemon(
        id = id,
        nama = name,
        imgUrl = sprites.frontDefault?: "",
        height = height,
        weight = weight,
        abilities = abilities.map { it.ability.name },
        stats = stats.map { statItem ->
            StatPokemon(
                name = statItem.stat.name,
                value = statItem.baseStat
            )
        },
        types = types.map { it.type.name }
    )
}