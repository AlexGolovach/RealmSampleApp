package com.renovavision.realmsampleapp.app

import com.renovavision.realmsampleapp.activity.NavigatorImpl
import com.renovavision.realmsampleapp.common.commonModule
import com.renovavision.realmsampleapp.database.databaseModule
import com.renovavision.realmsampleapp.countries.list.CountriesListFragment
import com.renovavision.realmsampleapp.countries.CountriesNavigator
import com.renovavision.realmsampleapp.countries.details.CountryDetailsFragment
import com.renovavision.realmsampleapp.countries.list.CountriesListViewModel
import com.renovavision.realmsampleapp.ui.navigation.Navigator
import org.koin.androidx.fragment.dsl.fragment
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module
import java.io.File

fun appModules(apiUrl: String, cacheDir: File) =
    listOf(commonModule(apiUrl, cacheDir), databaseModule, navigationModule, mainModule)

val navigationModule = module {
    val appNavigator = NavigatorImpl()
    single { appNavigator }
    single<Navigator> { appNavigator }
    single<CountriesNavigator> { appNavigator }
}

val mainModule = module {
    viewModel {
        CountriesListViewModel(
            get(),
            get()
        )
    }
    fragment { CountriesListFragment() }
    fragment { CountryDetailsFragment() }
}

