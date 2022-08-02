package com.example.homework7android11

import android.nfc.Tag
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.example.homework7android11.databinding.FragmentBottomDialogBinding
import com.google.android.material.bottomsheet.BottomSheetDialogFragment

open class BottomDialogFragment : BottomSheetDialogFragment() {

    private lateinit var binding: FragmentBottomDialogBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        binding = FragmentBottomDialogBinding.inflate(layoutInflater)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val model: PokedexModel = arguments?.getSerializable("key") as PokedexModel
        binding.tvPokemonName.text = model.name
        binding.tvDescription.text = model.descriptions
    }
}