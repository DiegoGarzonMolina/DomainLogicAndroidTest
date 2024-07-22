
package com.example.domainlogictest.platform.di

import com.example.domainlogictest.platform.App
import com.example.domainlogictest.ui.MainActivity
import dagger.Component

@Component(modules = arrayOf(MainModule::class))
interface RootComponent {
    fun inject(activity: MainActivity?) // BaseActivity can inject dependencies from this Component
    fun inject(application: App?)
}