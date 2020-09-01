package com.renovavision.realmsampleapp.database.realmobjects

import io.realm.RealmObject
import io.realm.annotations.PrimaryKey

open class CountryRealm(
    @PrimaryKey
    var name: String = "",
    var capital: String = "",
    var region: String = "",
    var subregion: String = "",
    var population: Int = 0,
    var area: Double? = 0.0,
    var languages: String = "",
    var flag: String = ""
) : RealmObject()