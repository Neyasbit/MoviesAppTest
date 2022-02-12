package com.example.moviesapp.di

import android.app.Activity
import androidx.navigation.NavController
import androidx.navigation.findNavController
import com.example.moviesapp.R
import com.example.navigation.Navigation
import com.example.navigation.Navigator
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent
import dagger.hilt.android.scopes.ActivityScoped

@Module
@InstallIn(ActivityComponent::class)
object ActivityModule {

    @ActivityScoped
    @Provides
    fun provideNavController(activity: Activity): NavController =
        activity.findNavController(R.id.nav_host_fragment)


    @Provides
    fun provideNavigator(navController: NavController): Navigation =
        Navigator(navController)
}
