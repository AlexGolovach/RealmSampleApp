package com.renovavision.realmsampleapp.common.mapper

import com.renovavision.realmsampleapp.common.entities.CountryEntity
import com.renovavision.realmsampleapp.common.model.Country
import com.renovavision.realmsampleapp.database.realmobjects.CountryRealm

typealias FunctionMapper<F, T> = ((from: F) -> T)

internal val countryMapper: FunctionMapper<CountryRealm, Country> = {
    Country(
        name = it.name,
        capital = it.capital,
        region = it.region,
        subregion = it.subregion,
        population = it.population,
        area = it.area,
        languages = it.languages,
        flag = it.flag
    )
}

internal val countryEntityMapper: FunctionMapper<CountryEntity, CountryRealm> = {
    CountryRealm(
        name = it.name,
        capital = it.capital,
        region = it.region,
        subregion = it.subregion,
        population = it.population,
        area = it.area,
        languages = it.getLanguages(),
        flag = it.flag
    )
}