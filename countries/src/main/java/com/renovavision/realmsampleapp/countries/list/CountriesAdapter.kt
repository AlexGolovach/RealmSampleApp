package com.renovavision.realmsampleapp.countries.list

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.view.ViewCompat
import com.renovavision.realmsampleapp.common.model.Country
import com.renovavision.realmsampleapp.countries.databinding.ItemViewCountryBinding
import com.renovavision.realmsampleapp.ui.ui.loadSvg
import com.renovavision.realmsampleapp.ui.ui.BaseAdapter
import com.renovavision.realmsampleapp.ui.ui.BaseViewHolder
import com.renovavision.realmsampleapp.ui.Dispatch

class CountriesAdapter(dispatch: Dispatch) :
    BaseAdapter<Country, CountriesAdapter.CountryViewHolder>(dispatch) {

    override fun buildViewHolder(parent: ViewGroup, viewType: Int) =
        CountryViewHolder(
            ItemViewCountryBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )

    override fun areItemsTheSame(oldItem: Country, newItem: Country) = oldItem.name == newItem.name

    inner class CountryViewHolder(private val binding: ItemViewCountryBinding) :
        BaseViewHolder<Country>(binding.root) {

        override fun onCreate(dispatch: Dispatch) {
            super.onCreate(dispatch)
            itemView.setOnClickListener {
                item.let {
                    dispatch.invoke(
                        CountryClicked(
                            it,
                            binding.image
                        )
                    )
                }
            }
        }

        override fun onBind(item: Country) {
            super.onBind(item)
            binding.textInfo.text = item.name

            ViewCompat.setTransitionName(binding.image, item.flag)
            binding.image.loadSvg(item.flag)
        }
    }
}