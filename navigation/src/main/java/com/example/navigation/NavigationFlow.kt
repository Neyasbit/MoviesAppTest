package com.example.navigation

import androidx.navigation.NavDirections

sealed class NavigationFlow {

    abstract fun directions() : NavDirections

    object HomeFlow : NavigationFlow() {
        override fun directions(): NavDirections = MainNavGraphDirections.actionSearchFlow()
    }
    class DetailFlow(private val name: String) : NavigationFlow() {
        override fun directions(): NavDirections = MainNavGraphDirections.actionDetailFlow(name)
    }
}