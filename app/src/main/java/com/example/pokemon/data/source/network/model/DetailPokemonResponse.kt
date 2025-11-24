package com.example.pokemon.data.source.network.model

import androidx.annotation.Keep
import com.google.gson.annotations.SerializedName

@Keep
data class DetailPokemonResponse(
    @SerializedName("id")
    val id: Int,
    @SerializedName("name")
    val name: String,
    @SerializedName("height")
    val height: Int,
    @SerializedName("weight")
    val weight: Int,
    @SerializedName("sprites")
    val sprites: Sprites,
    @SerializedName("abilities")
    val abilities: List<AbilitySlot>,
    @SerializedName("stats")
    val stats: List<StatSlot>,
    @SerializedName("types")
    val types: List<TypeSlot>
)

@Keep
data class Sprites(
    @SerializedName("front_default")
    val frontDefault: String?,
    @SerializedName("other")
    val other: OtherSprites?
)

@Keep
data class OtherSprites(
    @SerializedName("official-artwork")
    val officialArtwork: OfficialArtwork?
)

@Keep
data class OfficialArtwork(
    @SerializedName("front_default")
    val frontDefault: String?
)

@Keep
data class AbilitySlot(
    @SerializedName("ability")
    val ability: Ability,
    @SerializedName("is_hidden")
    val isHidden: Boolean,
    @SerializedName("slot")
    val slot: Int
)

@Keep
data class Ability(
    @SerializedName("name")
    val name: String,
    @SerializedName("url")
    val url: String
)

@Keep
data class StatSlot(
    @SerializedName("base_stat")
    val baseStat: Int,
    @SerializedName("effort")
    val effort: Int,
    @SerializedName("stat")
    val stat: Stat
)

@Keep
data class Stat(
    @SerializedName("name")
    val name: String,
    @SerializedName("url")
    val url: String
)

@Keep
data class TypeSlot(
    @SerializedName("slot")
    val slot: Int,
    @SerializedName("type")
    val type: Type
)

@Keep
data class Type(
    @SerializedName("name")
    val name: String,
    @SerializedName("url")
    val url: String
)

