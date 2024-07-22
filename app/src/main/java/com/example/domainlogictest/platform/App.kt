package com.example.domainlogictest.platform

import android.app.Application
import com.example.domainlogictest.platform.di.MainModule
import com.example.domainlogictest.platform.di.RootComponent
import java.io.File

class App : Application() {
    private var component: RootComponent? = null
    private var mainModule: MainModule? = null
    override fun onCreate() {
        super.onCreate()
        initializeDependencyInjector()
        initializeImageCache()
    }

    private fun initializeDependencyInjector() {
        mainModule = MainModule(this)
        component = DaggerRootComponent.builder()
            .build()
        component.inject(this)
    }

    fun initializeImageCache() {
        val cacheDir = picturesDir ?: return
        cacheDir.mkdirs()
    }

    fun getMainModule(): MainModule? {
        return mainModule
    }

    val picturesDir: File?
        get() = getExternalFilesDir(IMAGES_DIR)

    fun getComponent(): RootComponent? {
        return component
    }

    companion object {
        const val IMAGES_DIR = "images"
    }
}