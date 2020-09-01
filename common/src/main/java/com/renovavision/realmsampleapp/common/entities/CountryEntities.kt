package com.renovavision.realmsampleapp.common.entities

import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class CountryEntity(
    val name: String,
    val topLevelDomain: List<String>?,
    val alpha2Code: String?,
    val alpha3Code: String?,
    val callingCodes: List<String>?,
    val capital: String,
    val altSpellings: List<String>?,
    val region: String,
    val subregion: String,
    val population: Int,
    val latlng: List<Double>?,
    val demonym: String?,
    val area: Double?,
    val gini: Double?,
    val timezones: List<String>?,
    val borders: List<String>?,
    val nativeName: String?,
    val numericCode: String?,
    val currencies: List<CurrencyEntity>?,
    val languages: List<LanguageEntity>?,
    val translations: TranslationEntity?,
    val flag: String,
    val regionalBlocks: List<RegionalBlocEntity>?,
    val cioc: String?
) {
    fun getLanguages(): String {
        val list = mutableListOf<String>()

        languages?.forEach { list.add(it.name) }
        return list.joinToString(", ")
    }
}

@JsonClass(generateAdapter = true)
data class CurrencyEntity(
    val code: String?,
    val name: String?,
    val symbol: String?
)

@JsonClass(generateAdapter = true)
data class LanguageEntity(
    val iso639_1: String?,
    val iso639_2: String?,
    val name: String,
    val nativeName: String?
)

@JsonClass(generateAdapter = true)
data class TranslationEntity(
    val de: String?,
    val es: String?,
    val fr: String?,
    val ja: String?,
    val it: String?,
    val br: String?,
    val pt: String?,
    val nl: String?,
    val hr: String?,
    val fa: String?
)

@JsonClass(generateAdapter = true)
data class RegionalBlocEntity(
    val acronym: String?,
    val name: String?,
    val otherAcronyms: List<String>?,
    val otherNames: List<String>?
)