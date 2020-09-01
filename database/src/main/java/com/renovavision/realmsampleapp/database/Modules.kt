package com.renovavision.realmsampleapp.database

import com.renovavision.realmsampleapp.database.repo.DatabaseRepo
import io.realm.Realm
import io.realm.RealmConfiguration
import org.koin.dsl.module

val databaseModule = module {
    single {
        Realm.init(get())
        Realm.getInstance(
            RealmConfiguration.Builder()
                .name("countriesDb.realm")
                .build()
        )
    }
    single { DatabaseRepo(get()) }
}