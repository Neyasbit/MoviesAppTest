package com.example.moviesapp

import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.NavController
import androidx.navigation.ui.setupActionBarWithNavController
import com.example.navigation.Navigation
import com.example.navigation.NavigationFlow
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject
import javax.inject.Provider


@AndroidEntryPoint
class SingleActivity : AppCompatActivity(R.layout.activity_main), Navigation {

    @Inject
    lateinit var navigatorProvider: Provider<Navigation>

    @Inject
    lateinit var navProvider: Provider<NavController>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        /*
        Это костыль потому, что findNavController не успевает отработать.
        Можно решить через supportFragmentManager,
        найти  через  него контролер. Но я уже сделал через di
         */
        Handler(Looper.myLooper()!!).post {
            setupActionBarWithNavController(navProvider.get())
        }
    }

    override fun navigateToFlow(flow: NavigationFlow) =
        navigatorProvider.get().navigateToFlow(flow)

    override fun onSupportNavigateUp() =
        navProvider.get().navigateUp() || super.onSupportNavigateUp()

}
