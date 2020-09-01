package com.renovavision.realmsampleapp.common

import com.renovavision.realmsampleapp.common.api.CountriesApi
import com.renovavision.realmsampleapp.common.repo.CountriesRepo
import okhttp3.Cache
import okhttp3.OkHttpClient
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import java.io.File

fun commonModule(apiUrl: String, cacheDir: File?) = module {
    single {
        Retrofit.Builder()
            .baseUrl(apiUrl)
            .callFactory(OkHttpClient.Builder().apply {
                cacheDir?.let { cache(Cache(it, 1024 * 1024 * 100)) }
            }.build())
            .addConverterFactory(MoshiConverterFactory.create())
            .build()
    }
    factory { (get<Retrofit>()).create(CountriesApi::class.java) }
    single { CountriesRepo(get(), get()) }
}