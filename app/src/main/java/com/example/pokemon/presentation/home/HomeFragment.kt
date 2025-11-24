package com.example.pokemon.presentation.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.pokemon.R
import com.example.pokemon.data.model.pokemon.Pokemon
import com.example.pokemon.databinding.FragmentHomeBinding
import com.example.pokemon.utils.proceedWhen
import org.koin.androidx.viewmodel.ext.android.viewModel

class HomeFragment : Fragment() {

    private lateinit var binding: FragmentHomeBinding
    private val viewModel: HomeViewModel by viewModel()
    private val adapter: PokemonAdapter by lazy {
        PokemonAdapter { navigateToDetail(it) }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.rvPokemon.adapter = adapter
        observeData()
    }

    private fun observeData() {
        viewModel.getDataAllPokemon().observe(viewLifecycleOwner) { result ->
            result.proceedWhen(
                doOnSuccess = {
                    binding.tvLoading.isVisible = false
                    binding.tvEror.isVisible = false
                    adapter.submitData(it.payload?: emptyList())
                },
                doOnLoading = {
                    binding.tvLoading.isVisible = true
                },
                doOnError = {
                    binding.tvLoading.isVisible = false
                    binding.tvEror.isVisible = true
                }
            )
        }
    }

    private fun navigateToDetail(pokemon: Pokemon) {
        val bundle = Bundle().apply {
            putString("EXTRAS_POKEMON", pokemon.name)
        }
        findNavController().navigate(
            R.id.action_homeFragment_to_detailFragment,
            bundle
        )
    }


}
