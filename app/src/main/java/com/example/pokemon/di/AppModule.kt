package com.example.pokemon.di

import com.example.pokemon.data.datasource.AllPokemonDataSource
import com.example.pokemon.data.datasource.AllPokemonDataSourceImpl
import com.example.pokemon.data.datasource.DetailPokemonDataSource
import com.example.pokemon.data.datasource.DetailPokemonDataSourceImpl
import com.example.pokemon.data.repository.AllPokemonRepository
import com.example.pokemon.data.repository.AllPokemonRepositoryImpl
import com.example.pokemon.data.repository.DetailPokemonRepository
import com.example.pokemon.data.repository.DetailPokemonRepositoryImpl
import com.example.pokemon.data.source.network.service.PokemonApiService
import com.example.pokemon.presentation.detail.DetailViewModel
import com.example.pokemon.presentation.home.HomeViewModel
import org.koin.androidx.viewmodel.dsl.viewModelOf
import org.koin.dsl.module

object AppModule {
    private val networkModule =
        module{
            single<PokemonApiService> { PokemonApiService.invoke() }
        }

    private val dataSourceModule =
        module{
            single<DetailPokemonDataSource> { DetailPokemonDataSourceImpl(get()) }
            single<AllPokemonDataSource> { AllPokemonDataSourceImpl(get()) }
        }
    private val repositoryModule =
        module {
            single<DetailPokemonRepository> { DetailPokemonRepositoryImpl(get()) }
            single<AllPokemonRepository> { AllPokemonRepositoryImpl(get()) }
        }
    private val viewModelModule =
        module{
            viewModelOf(::HomeViewModel)
            viewModelOf(::DetailViewModel)
        }

    val modules =
        listOf(
            networkModule,
            dataSourceModule,
            repositoryModule,
            viewModelModule
        )
}