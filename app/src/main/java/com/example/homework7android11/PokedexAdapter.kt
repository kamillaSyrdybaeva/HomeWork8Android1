package com.example.homework7android11

import android.content.Context
import android.graphics.Color
import android.graphics.drawable.GradientDrawable
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.homework7android11.databinding.ItemPokemonBinding

class PokedexAdapter(var list: ArrayList<PokedexModel>, val itemClicker: OnItemClicker) :
    RecyclerView.Adapter<PokedexAdapter.PokemonHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PokemonHolder {
        return PokemonHolder(ItemPokemonBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

    override fun onBindViewHolder(holder: PokemonHolder, position: Int) {
        holder.onBind(list[position])
    }

    override fun getItemCount(): Int = list.size

    inner class PokemonHolder(private var binding: ItemPokemonBinding) : RecyclerView.ViewHolder(binding.root) {

        fun onBind(pokemonModel: PokedexModel) {

            itemView.setOnClickListener {
                itemClicker.onItemClick(pokemonModel)
            }

            binding.tvNumberPokemon.text = pokemonModel.number
            binding.ivPokemonImage.setImageResource(pokemonModel.image)
            binding.idTvNamePokemon.text = pokemonModel.name
            changeStrokeColor(binding.containerPokedex, pokemonModel.color)
            changeSolidColor(binding.idTvNamePokemon, pokemonModel.color)
            binding.tvNumberPokemon.setTextColor(Color.parseColor(pokemonModel.color))
        }
    }

    private fun changeStrokeColor(view: View, color: String) {
        val drawable: GradientDrawable = view.background as GradientDrawable
        drawable.mutate()
        drawable.setStroke(4, Color.parseColor(color))
    }

    private fun changeSolidColor(view :View, color: String) {
        val drawable: GradientDrawable = view.background as GradientDrawable
        drawable.mutate()
        drawable.setStroke(4, Color.parseColor(color))
        drawable.setColor(Color.parseColor(color))
    }
}