package com.renovavision.realmsampleapp.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.renovavision.realmsampleapp.R
import org.koin.android.ext.android.inject
import org.koin.androidx.fragment.android.setupKoinFragmentFactory

class MainActivity : AppCompatActivity(R.layout.activity_main) {

    private val navigatorImpl: NavigatorImpl by inject()

    override fun onCreate(savedInstanceState: Bundle?) {
        setupKoinFragmentFactory()
        setTheme(R.style.AppTheme)
        super.onCreate(savedInstanceState)
        navigatorImpl.bind(this)
    }

    override fun onDestroy() {
        navigatorImpl.unbind()
        super.onDestroy()
    }
}