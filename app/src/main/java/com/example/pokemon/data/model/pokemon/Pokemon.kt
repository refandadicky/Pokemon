package com.example.pokemon.data.model.pokemon

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Pokemon(
    var name: String?,
    var imgUrl: String
) : Parcelable

