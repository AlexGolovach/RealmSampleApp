package com.renovavision.realmsampleapp.countries.list

import androidx.appcompat.widget.AppCompatImageView
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.renovavision.realmsampleapp.common.model.Country
import com.renovavision.realmsampleapp.common.repo.CountriesRepo
import com.renovavision.realmsampleapp.countries.CountriesNavigator
import com.renovavision.realmsampleapp.ui.Event
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

object LoadCountries : Event
data class CountryClicked(
    val country: Country,
    val imageView: AppCompatImageView
) : Event

data class State(
    val isLoading: Boolean,
    val showError: Boolean,
    val items: List<Country> = emptyList()
)

class CountriesListViewModel(
    private val countriesRepo: CountriesRepo,
    private val countriesNavigator: CountriesNavigator
) : ViewModel() {

    @ExperimentalCoroutinesApi
    private val _state = MutableStateFlow(
        State(
            isLoading = true,
            showError = false
        )
    )

    @ExperimentalCoroutinesApi
    val state: StateFlow<State> = _state

    @ExperimentalCoroutinesApi
    fun dispatch(event: Event) {
        when (event) {
            is LoadCountries -> loadCountries()
            is CountryClicked -> countriesNavigator.navToCountryDetailsScreen(
                event.country,
                event.imageView
            )
        }
    }

    @ExperimentalCoroutinesApi
    private fun loadCountries() {
        _state.value = State(
            isLoading = true,
            showError = false
        )
        viewModelScope.launch {
            countriesRepo.loadCountries()
                .catch {
                    _state.value =
                        State(
                            isLoading = false,
                            showError = true
                        )
                }
                .collect {
                    when (it.isEmpty()) {
                        true -> _state.value =
                            State(
                                isLoading = false,
                                showError = true
                            )
                        else -> _state.value =
                            State(
                                isLoading = false,
                                showError = false,
                                items = it
                            )
                    }
                }
        }
    }
}