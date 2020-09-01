package com.renovavision.realmsampleapp.activity

import androidx.appcompat.widget.AppCompatImageView
import androidx.navigation.findNavController
import androidx.navigation.fragment.FragmentNavigatorExtras
import com.renovavision.realmsampleapp.R
import com.renovavision.realmsampleapp.common.model.Country
import com.renovavision.realmsampleapp.countries.CountriesNavigator
import com.renovavision.realmsampleapp.home.list.CountriesListFragmentDirections
import com.renovavision.realmsampleapp.ui.navigation.Navigator

class NavigatorImpl : Navigator, CountriesNavigator {

    private var activity: MainActivity? = null

    fun bind(mainActivity: MainActivity) {
        this.activity = mainActivity
    }

    fun unbind() {
        this.activity = null
    }

    override fun navBack() {
        activity?.apply {
            runOnUiThread {
                findNavController(R.id.navHostFragment).popBackStack()
            }
        }
    }

    override fun navToCountryDetailsScreen(country: Country, imageView: AppCompatImageView) {
        activity?.apply {
            runOnUiThread {
                val extras = FragmentNavigatorExtras(imageView to country.flag)

                findNavController(R.id.navHostFragment).navigate(
                    CountriesListFragmentDirections.navigateToCountryDetails(country), extras
                )
            }
        }
    }
}

