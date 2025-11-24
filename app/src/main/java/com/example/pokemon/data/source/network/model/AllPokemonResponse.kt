package com.example.pokemon.data.source.network.model

import androidx.annotation.Keep
import com.google.gson.annotations.SerializedName


@Keep
data class AllPokemonResponse(
    @SerializedName("count")
    val count: Int? = null,
    @SerializedName("next")
    val next: String? = null,
    @SerializedName("previous")
    val previous: String? = null,
    @SerializedName("results")
    val results: List<PokemonResult>? = null
)

@Keep
data class PokemonResult(
    @SerializedName("name")
    val name: String? = null,
    @SerializedName("url")
    val url: String? = null
)
