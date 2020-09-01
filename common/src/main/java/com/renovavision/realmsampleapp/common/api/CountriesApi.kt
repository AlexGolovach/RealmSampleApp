package com.renovavision.realmsampleapp.common.api

import com.renovavision.realmsampleapp.common.entities.CountryEntity
import retrofit2.http.GET

interface CountriesApi {

    @GET("all")
    suspend fun loadCountriesList(): List<CountryEntity>
}