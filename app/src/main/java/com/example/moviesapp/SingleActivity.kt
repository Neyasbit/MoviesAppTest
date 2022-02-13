package com.example.moviesapp

import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.setupActionBarWithNavController
import com.example.navigation.Navigation
import com.example.navigation.NavigationFlow
import com.example.navigation.Navigator
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject
import javax.inject.Provider


@AndroidEntryPoint
class SingleActivity : AppCompatActivity(R.layout.activity_main), Navigation {

    /*
        делал через di, но там костыль приходится использовать,
        можно посмотреть на гите до последнего комита
     */

    private lateinit var navigator: Navigation
    private lateinit var navController: NavController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val navHostFragment = supportFragmentManager.findFragmentById(R.id.nav_host_fragment)
                as NavHostFragment

        navController = navHostFragment.navController
        navigator = Navigator(navController)
        setupActionBarWithNavController(navController)
    }

    override fun navigateToFlow(flow: NavigationFlow) =
        navigator.navigateToFlow(flow)

    override fun onSupportNavigateUp() =
        navController.navigateUp() || super.onSupportNavigateUp()

}
