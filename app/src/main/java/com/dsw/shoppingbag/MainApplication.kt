package com.dsw.shoppingbag

import android.app.Application
import com.dsw.shoppingbag.dagger.AndroidModule
import com.dsw.shoppingbag.dagger.DaggerApplicationComponent
import com.dsw.shoppingbag.view.activities.MainActivity
//import com.dsw.shoppingbag.dagger.DaggerApplicationComponent
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.HasAndroidInjector
import javax.inject.Inject

class MainApplication : Application(), HasAndroidInjector {

    // Reference to the application graph that is used across the whole app
    @Inject
    lateinit var dispatchingAndroidInjector: DispatchingAndroidInjector<Any>

    override fun androidInjector(): AndroidInjector<Any> {
        return dispatchingAndroidInjector
    }

    override fun onCreate() {
        super.onCreate()

        DaggerApplicationComponent.builder()
            .androidModule(AndroidModule(MainApplication()))
            .build()
    }
}