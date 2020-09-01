package com.renovavision.realmsampleapp.countries.details

import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.transition.TransitionInflater
import com.renovavision.realmsampleapp.common.model.Country
import com.renovavision.realmsampleapp.countries.R
import com.renovavision.realmsampleapp.countries.databinding.FragmentCountryDetailsBinding
import com.renovavision.realmsampleapp.ui.ui.bindingDelegate
import com.renovavision.realmsampleapp.ui.ui.onViewLifecycle

class CountryDetailsFragment : Fragment(R.layout.fragment_country_details) {

    private val binding by bindingDelegate(FragmentCountryDetailsBinding::bind)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        sharedElementEnterTransition =
            TransitionInflater.from(context).inflateTransition(android.R.transition.move)

        val countryDetails = arguments?.getSerializable("country") as Country

        onViewLifecycle({ binding.toolbar }, {
            title = context.getString(R.string.country_details)
        })

        onViewLifecycle({ binding.mealDetailsView }, {
            country = countryDetails
        })
    }
}