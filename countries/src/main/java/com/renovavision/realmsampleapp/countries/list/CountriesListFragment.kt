package com.renovavision.realmsampleapp.countries.list

import android.os.Bundle
import android.view.View
import androidx.core.view.doOnPreDraw
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import com.renovavision.realmsampleapp.countries.R
import com.renovavision.realmsampleapp.countries.databinding.FragmentCountriesListBinding
import com.renovavision.realmsampleapp.ui.ui.bindingDelegate
import com.renovavision.realmsampleapp.ui.ui.onViewLifecycle
import com.yarolegovich.discretescrollview.DSVOrientation
import com.yarolegovich.discretescrollview.DiscreteScrollView
import com.yarolegovich.discretescrollview.InfiniteScrollAdapter
import com.yarolegovich.discretescrollview.transform.ScaleTransformer
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.collect
import org.koin.androidx.viewmodel.ext.android.viewModel

class CountriesListFragment : Fragment(R.layout.fragment_countries_list) {

    private val viewModel: CountriesListViewModel by viewModel()

    private val binding by bindingDelegate(FragmentCountriesListBinding::bind)

    private val countriesAdapter = CountriesAdapter {
        viewModel.dispatch(it)
    }

    @ExperimentalCoroutinesApi
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        onViewLifecycle({ binding.errorContainer },
            {
                errorMessage = context.getString(R.string.error)
                clickListener =
                    View.OnClickListener { viewModel.dispatch(LoadCountries) }
            }, {
                clickListener = null
            })

        viewModel.dispatch(LoadCountries)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        view.findViewById<DiscreteScrollView>(R.id.item_picker).apply {
            setOrientation(DSVOrientation.HORIZONTAL)
            setItemTransformer(
                ScaleTransformer.Builder()
                    .setMinScale(0.8f)
                    .build()
            )
            adapter = InfiniteScrollAdapter.wrap(countriesAdapter)

            postponeEnterTransition()
            doOnPreDraw {
                startPostponedEnterTransition()
            }
        }
    }

    @ExperimentalCoroutinesApi
    override fun onStart() {
        super.onStart()

        lifecycleScope.launchWhenStarted {
            viewModel.state.collect {
                countriesAdapter.updateItems(it.items)
                binding.itemPicker.visibility = if (!it.showError) View.VISIBLE else View.GONE
                binding.errorContainer.visibility = if (it.showError) View.VISIBLE else View.GONE
                binding.progress.visibility = if (it.isLoading) View.VISIBLE else View.GONE
            }
        }
    }
}