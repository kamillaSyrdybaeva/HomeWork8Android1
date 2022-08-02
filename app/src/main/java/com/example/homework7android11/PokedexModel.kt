package com.example.homework7android11

import java.io.Serializable

data class PokedexModel(
    val number: String,
    val name: String,
    val image: Int,
    val color: String,
    val ability: String,
    val weight: String,
    val height: String,
    val moves: String,
    val descriptions: String,
    val hp: String,
    val attack: String,
    val def: String,
    val sdef: String,
    val satk: String,
    val spd: String
) : Serializable
