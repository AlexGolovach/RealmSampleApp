package com.renovavision.realmsampleapp.common.repo

import com.renovavision.realmsampleapp.common.api.CountriesApi
import com.renovavision.realmsampleapp.common.mapper.countryEntityMapper
import com.renovavision.realmsampleapp.common.mapper.countryMapper
import com.renovavision.realmsampleapp.database.repo.DatabaseRepo
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.channels.awaitClose
import kotlinx.coroutines.flow.callbackFlow

class CountriesRepo(private val api: CountriesApi, private val databaseRepo: DatabaseRepo) {

    @ExperimentalCoroutinesApi
    fun loadCountries() = networkBoundedFlow(
        callbackFlow {
            val result = databaseRepo.getCountriesList()
            result.addChangeListener { _ ->
                offer(result.map { countryMapper(it) })
            }
            awaitClose { result.removeAllChangeListeners() }
        },
        {
            val list = it.map { countryEntityMapper(it) }
            databaseRepo.addToDatabase(list)
        },
        { api.loadCountriesList() }
    )
}