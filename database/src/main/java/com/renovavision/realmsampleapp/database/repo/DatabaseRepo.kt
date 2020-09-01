package com.renovavision.realmsampleapp.database.repo

import com.renovavision.realmsampleapp.database.realmobjects.CountryRealm
import io.realm.Realm

class DatabaseRepo(private val realm: Realm) {

    fun getCountriesList() = realm.where(CountryRealm::class.java).findAllAsync()

    fun addToDatabase(list: List<CountryRealm>) {
        realm.executeTransaction {
            it.copyToRealmOrUpdate(list)
        }
    }
}