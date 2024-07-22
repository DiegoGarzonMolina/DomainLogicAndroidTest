package com.example.domainlogictest.platform.di

import android.content.Context
import com.example.domainlogictest.data.api.GetUsersApiImpl
import com.example.domainlogictest.domain.repository.UserRepository
import com.example.domainlogictest.platform.interactor.GetUsersInteractor
import com.example.domainlogictest.platform.interactor.impl.MainThreadImpl
import com.example.domainlogictest.platform.interactor.impl.ThreadExecutor
import com.example.domainlogictest.platform.App
import dagger.Module
import dagger.Provides
import javax.inject.Named

@Module
class MainModule(application: App) {
    private val application: App
    var interactor: GetUsersInteractor
    var userRepository: UserRepository

    init {
        this.application = application
        interactor = GetUsersInteractor(
            GetUsersApiImpl(10, 0),
            ThreadExecutor(),
            MainThreadImpl()
        )
        userRepository = UserRepository(
            application, interactor
        )
    }

    @Provides
    fun provideUserInteractor(): GetUsersInteractor {
        return interactor
    }

    @Provides
    fun provideUserRepository(): UserRepository {
        return userRepository
    }

    @Provides
    @Named("applicationContext")
    fun provideApplicationContext(): Context {
        return application.getApplicationContext()
    }
}