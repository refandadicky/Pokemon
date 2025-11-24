package com.example.pokemon.data.source.network.service

import android.R.attr.level
import com.example.pokemon.BuildConfig
import com.example.pokemon.data.source.network.model.AllPokemonResponse
import com.example.pokemon.data.source.network.model.DetailPokemonResponse
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Path
import java.util.concurrent.TimeUnit

interface PokemonApiService {
    @GET("pokemon")
    suspend fun getAllPokemon(): AllPokemonResponse
    @GET("pokemon/{name}")
    suspend fun getDetailPokemon(
        @Path("name") name: String
    ): DetailPokemonResponse

    companion object {
        @JvmStatic
        operator fun invoke(): PokemonApiService{
            val logging = HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY)
            val okHttpClient = OkHttpClient.Builder()
                .addInterceptor(logging)
                .connectTimeout(120, TimeUnit.SECONDS)
                .readTimeout(120, TimeUnit.SECONDS)
                .build()
            val retrofit =
                Retrofit.Builder()
                    .baseUrl(BuildConfig.BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .client(okHttpClient)
                    .build()
            return retrofit.create(PokemonApiService::class.java)
        }
    }
}