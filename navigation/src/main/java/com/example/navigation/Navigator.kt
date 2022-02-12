package com.example.navigation

import androidx.navigation.NavController

class Navigator(
    private val navController: NavController
) : Navigation {
    override fun navigateToFlow(flow: NavigationFlow) =
        navController.navigate(flow.directions())
}