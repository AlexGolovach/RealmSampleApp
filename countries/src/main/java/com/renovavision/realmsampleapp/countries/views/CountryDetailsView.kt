package com.renovavision.realmsampleapp.countries.views

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.view.ViewCompat
import com.renovavision.realmsampleapp.common.model.Country
import com.renovavision.realmsampleapp.countries.R
import com.renovavision.realmsampleapp.countries.databinding.CountryDetailsViewBinding
import com.renovavision.realmsampleapp.ui.ui.loadSvg

class CountryDetailsView @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
) : ConstraintLayout(context, attrs, defStyleAttr) {

    private val binding = CountryDetailsViewBinding.inflate(LayoutInflater.from(context), this)

    @get:JvmSynthetic
    var country: Country
        get() = throw UnsupportedOperationException()
        set(value) {
            ViewCompat.setTransitionName(binding.flagImage, value.flag)
            binding.flagImage.loadSvg(value.flag)

            binding.countryText.text = context.getString(R.string.country, value.name)
            binding.capitalText.updateField(context.getString(R.string.capital, value.capital))
            binding.regionText.updateField(context.getString(R.string.region, value.region))
            binding.areaText.updateField(context.getString(R.string.area, value.area.toString()))
            binding.populationText.updateField(
                context.getString(
                    R.string.population,
                    value.population.toString()
                )
            )
            binding.languagesText.updateField(
                context.getString(
                    R.string.languages,
                    value.languages
                )
            )
        }

    private fun TextView.updateField(info: String?) {
        if (!info.isNullOrEmpty()) {
            text = info
        } else {
            visibility = GONE
        }
    }
}