package com.example.pokemon.data.mapper

import com.example.pokemon.data.model.pokemon.Pokemon
import com.example.pokemon.data.source.network.model.PokemonResult

fun PokemonResult.toAllPokemon(): Pokemon {
    val id = extractIdFromUrl(url ?: "")
    return Pokemon(
        name = name,
        imgUrl = "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/$id.png"

    )
}
fun List<PokemonResult>.toAllPokemonList(): List<Pokemon> {
    return this.map { it.toAllPokemon() }
}

private fun extractIdFromUrl(url: String): Int {
    return url.trimEnd('/').split("/").last().toIntOrNull() ?: 0
}