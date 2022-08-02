package com.example.homework7android11

import android.annotation.SuppressLint
import android.graphics.Color
import android.graphics.ColorSpace
import android.graphics.drawable.GradientDrawable
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.Window
import android.view.animation.AnimationUtils
import android.widget.TextView
import androidx.navigation.fragment.findNavController
import com.example.homework7android11.databinding.FragmentDetailBinding
import com.google.android.material.progressindicator.LinearProgressIndicator
import org.w3c.dom.Text

class DetailFragment : Fragment() {

    private lateinit var binding :FragmentDetailBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        binding = FragmentDetailBinding.inflate(layoutInflater)
        return binding.root
    }

    @SuppressLint("InflateParams")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.ivBack.setOnClickListener {
            findNavController().navigate(R.id.pokemonListFragment)
        }
        val window = activity?.window

        val model: PokedexModel = arguments?.getSerializable("model") as PokedexModel
        changeSolidColor(binding.containerDetail, model.color)

        if (window != null) {
            changeColorStatusBar(window, model.color)
        }

        binding.tvNameDetail.text = model.name
        binding.ivPokemonImage.setImageResource(model.image)
        binding.tvNumberPokemon.text = model.number
        binding.tvAbility.text = model.ability
        changeSolidColor(binding.tvAbility, model.color)
        binding.tvAbout.setTextColor(Color.parseColor(model.color))
        binding.tvWeight.text = model.weight
        binding.tvNumberHeight.text = model.height
        binding.tvMovesPokemon.text = model.moves
        binding.tvDescription.text = model.descriptions
        binding.tvBaseStatic.setTextColor(Color.parseColor(model.color))
        binding.tvNumberHp.text = model.hp
        binding.tvNumberAtk.text = model.attack
        binding.tvNumberDef.text = model.def
        binding.tvNumberSdef.text = model.sdef
        binding.tvNumberSatk.text = model.satk
        binding.tvNumberSpd.text = model.spd
        binding.tvHp.setTextColor(Color.parseColor(model.color))
        binding.tvAtk.setTextColor(Color.parseColor(model.color))
        binding.tvDef.setTextColor(Color.parseColor(model.color))
        binding.tvSdef.setTextColor(Color.parseColor(model.color))
        binding.tvSatk.setTextColor(Color.parseColor(model.color))
        binding.tvSpd.setTextColor(Color.parseColor(model.color))

        setColorProgressBar(binding.progressHp, model.color, model.hp.toInt())
        setColorProgressBar(binding.progressAtk, model.color, model.attack.toInt())
        setColorProgressBar(binding.progressDef, model.color, model.def.toInt())
        setColorProgressBar(binding.progressSdef, model.color, model.sdef.toInt())
        setColorProgressBar(binding.progressSatk, model.color, model.satk.toInt())
        setColorProgressBar(binding.progressSpd, model.color, model.spd.toInt())

        binding.ivPokemonImage.setOnClickListener {
            val animation = AnimationUtils.loadAnimation(requireContext(), R.anim.animation_pokemon)
            binding.ivPokemonImage.startAnimation(animation)

            val bottomDialogFragment = BottomDialogFragment()
            bottomDialogFragment.show(requireActivity().supportFragmentManager, "")
            val bundle = Bundle()
            bundle.putSerializable("key", model)
            bottomDialogFragment.arguments = bundle

        }
    }

    private fun changeColorStatusBar(window: Window, color: String) {
        window.statusBarColor = Color.parseColor(color)
    }

    private fun setColorProgressBar(progressBar: LinearProgressIndicator, color: String, progress: Int) {
        progressBar.setIndicatorColor(Color.parseColor(color))
        progressBar.progress = progress
    }

    private fun changeSolidColor(view: View, color: String) {
        val drawable: GradientDrawable = view.background as GradientDrawable
        drawable.mutate()
        drawable.setStroke(4, Color.parseColor(color))
        drawable.setColor(Color.parseColor(color))
    }
}