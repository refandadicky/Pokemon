package com.example.pokemon.presentation.detail

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.navigation.fragment.findNavController
import coil.load
import com.example.pokemon.data.model.detailpokemon.DetailPokemon
import com.example.pokemon.databinding.FragmentDetailBinding
import com.example.pokemon.utils.proceedWhen
import org.koin.androidx.viewmodel.ext.android.viewModel
import org.koin.core.parameter.parametersOf



class DetailFragment : Fragment() {
    private lateinit var binding: FragmentDetailBinding
    private var detail: DetailPokemon? = null
    private val viewModel: DetailViewModel by viewModel {
        parametersOf(arguments)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentDetailBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        observeData()
        setClickAction()
    }

    private fun setClickAction() {
        binding.ivBack.setOnClickListener {
            findNavController().navigateUp()
        }
    }

    private fun observeData() {
        viewModel.pokemon?.name.let {
            it?.let { it ->
                viewModel.getDetail(it).observe(viewLifecycleOwner) {result ->
                    result.proceedWhen(
                        doOnSuccess = { success ->
                            success.payload.let { detailPokemon ->
                                detail = detailPokemon
                                binding.tvEror.isVisible = false
                                setBind(detailPokemon)

                            }
                        },
                        doOnLoading = {
                            binding.tvLoading.isVisible = true
                            binding.tvNamePokemon.isVisible = false
                            binding.tvAbilities.isVisible = false
                            binding.tvStats.isVisible = false
                            binding.tvTypes.isVisible = false
                            binding.tvHeight.isVisible = false
                            binding.tvWeight.isVisible = false
                            binding.ivPokemonPhoto.isVisible = false
                        },
                        doOnError = {
                            binding.tvEror.isVisible = true
                            binding.tvNamePokemon.isVisible = false
                            binding.tvAbilities.isVisible = false
                            binding.tvStats.isVisible = false
                            binding.tvTypes.isVisible = false
                            binding.tvHeight.isVisible = false
                            binding.tvWeight.isVisible = false
                            binding.ivPokemonPhoto.isVisible = false
                        },
                    )
                }
            }
        }
    }

    private fun setBind(pokemon: DetailPokemon?) {
        pokemon?.let {
            binding.ivPokemonPhoto.load(it.imgUrl)
            binding.tvNamePokemon.text = it.nama
            binding.tvHeight.text = it.height.toString()
            binding.tvWeight.text = it.weight.toString()
            binding.tvAbilities.text = it.abilities.joinToString(", ")
            binding.tvTypes.text = it.types.joinToString(", ")
            binding.tvStats.text = it.stats.joinToString { "${it.name}: ${it.value}" }

        }

    }

    companion object {
        const val EXTRAS_POKEMON = "EXTRAS_POKEMON"
    }
}


