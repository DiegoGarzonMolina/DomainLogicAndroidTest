package com.example.domainlogictest.utils

import android.content.Context
import com.example.domainlogictest.domain.usecase.ShowUserGreeting
import com.example.domainlogictest.ui.model.User

/**
 * Created by olmo on 31/10/16.
 */
class ShowToastImpl(var context: Context) : ShowUserGreeting {
    override fun show(user: User?) {
    }
}