package com.example.navigation

interface Navigation {

    fun navigateToFlow(flow: NavigationFlow)

    class Empty : Navigation {
        override fun navigateToFlow(flow: NavigationFlow) = Unit
    }
}