package com.example.homework7android11

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.homework7android11.databinding.FragmentPokemonListBinding


class PokemonListFragment : Fragment(), OnItemClicker {

    private lateinit var binding: FragmentPokemonListBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        binding = FragmentPokemonListBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initAdapter()

    }

    private fun initAdapter() {
        val list = arrayListOf<PokedexModel>()
        list.add(PokedexModel("#001", "Bulbasaur", R.drawable.img_1,"#74CB48", "Grass","6,9 kg", "0,7m", "Chlorophyll \nOvergrow", "There is a plant seed on its back right from the day this Pokémon is born. The seed slowly grows larger.", "045", "049", "049", "065", "065", "045"))
        list.add(PokedexModel("#004", "Charmander", R.drawable.img_2, "#F57D31", "Fire","8,5 kg", "0,6 m", "Mega-Punch \nFire-Punch","It has a preference for hot things. When it rains, steam is said to spout from the tip of its tail.","039","052", "043", "060", "050", "065"))
        list.add(PokedexModel("#007", "Squirtle", R.drawable.img, "#6493EB", "Water","9,0 kg", "0,5 m", "Torrent \nRain-Dish", "When it retracts its long neck into its shell, it squirts out water with vigorous force.", "044", "048", "065","050", "064", "043"))
        list.add(PokedexModel("#012", "Butterfree", R.drawable.img_3, "#A7B723", "Flying","32,0 kg", "1,1 m", "Compound-Eyes \nTinted-Lines", "In battle, it flaps its wings at great speed to release highly toxic dust into the air.", "060", "045", "050", "090", "080", "070"))
        list.add(PokedexModel("#025", "Pikachu", R.drawable.img_4, "#F9CF30", "Electric","6,0 kg", "0,4 m", "Mega-Punch \nPay-Day", "Pikachu that can generate powerful electricity have cheek sacs that are extra soft and super stretchy.", "035", "055", "040", "050", "050", "090"))
        list.add(PokedexModel("#092", "Gastly", R.drawable.img_5, "#70559B", "Ghost", "0,1 kg", "1,3 m", "Levitate", "Born from gases, anyone would faint if engulfed by its gaseous body, which contains poison.","030", "035", "030", "100", "035", "080"))
        list.add(PokedexModel("#132", "Ditto", R.drawable.img_6, "#AAA67F", "Normal", "4,0 kg", "0,3 m", "Limber \nImposter", "It can reconstitute its entire cellular structure to change into what it sees, but it returns to normal when it relaxes.", "048", "048", "048", "048", "048", "048" ))
        list.add(PokedexModel("#152", "Mew", R.drawable.img_7, "#FB5584", "Psychic","4,0 kg", "0,4 m", "Synchronize", "When viewed through a microscope, this Pokémon’s short, fine, delicate hair can be seen.", "100","100","100","100","100","100"))
        list.add(PokedexModel("#304", "Aron", R.drawable.img_8, "#B7B9D0","Steel", "60,0 kg", "0,4 m", "Sturdy \nRock-Head", "It eats iron ore - and sometimes railroad tracks - to build up the steel armor that protects its body.", "050", "070", "100", "040", "040", "030"))
        val adapter = PokedexAdapter(list, this)
        binding.rvPokemon.adapter = adapter
    }

    override fun onItemClick(model: PokedexModel) {
        val bundle = Bundle()
        bundle.putSerializable("model", model)
        findNavController().navigate(R.id.detailFragment, bundle)
    }
}