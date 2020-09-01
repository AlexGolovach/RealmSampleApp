package com.renovavision.realmsampleapp.common.model

import java.io.Serializable

data class Country(
    val name: String,
    val capital: String,
    val region: String,
    val subregion: String,
    val population: Int,
    val area: Double?,
    val languages: String,
    val flag: String
): Serializable