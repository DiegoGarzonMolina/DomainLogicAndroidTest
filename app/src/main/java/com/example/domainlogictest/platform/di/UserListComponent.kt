package com.example.domainlogictest.platform.di

import com.example.domainlogictest.ui.MainActivity
import dagger.Component

@Component(dependencies = [RootComponent::class], modules = [UserListModule::class, MainModule::class])
interface UserListComponent {
    fun inject(activity: MainActivity?)
}