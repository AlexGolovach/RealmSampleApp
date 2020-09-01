package com.renovavision.realmsampleapp.countries

import androidx.appcompat.widget.AppCompatImageView
import com.renovavision.realmsampleapp.common.model.Country

interface CountriesNavigator {

    fun navToCountryDetailsScreen(country: Country, imageView: AppCompatImageView)
}