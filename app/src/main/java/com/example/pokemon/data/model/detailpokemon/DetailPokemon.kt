package com.example.pokemon.data.model.detailpokemon

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class DetailPokemon(
    val id: Int,
    val nama: String,
    val imgUrl: String,
    val height: Int,
    val weight: Int,
    val abilities: List<String>,
    val stats: List<StatPokemon>,
    val types: List<String>
) : Parcelable

@Parcelize
data class StatPokemon(
    val name: String,
    val value: Int
) : Parcelable
