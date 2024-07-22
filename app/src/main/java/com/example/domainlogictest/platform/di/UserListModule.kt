package com.example.domainlogictest.platform.di

import android.content.Context
import com.example.domainlogictest.utils.ShowToastImpl
import dagger.Module
import dagger.Provides

@Module
class UserListModule(var mContext: Context) {
    var showToastImpl: ShowToastImpl

    init {
        showToastImpl = ShowToastImpl(mContext)
    }

    @Provides
    fun provideShowToastImpl(): ShowToastImpl {
        return showToastImpl
    }


}