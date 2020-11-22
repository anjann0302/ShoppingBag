package com.dsw.shoppingbag.dagger

import android.app.Application
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

/**
 * This class provides application context to the Dagger, which can be used in RetrofitBuilder and Room Database
 */
@Module
class AndroidModule(application: Application) {
    var application: Application = application

    @Provides
    @Singleton
    fun providesApplication(): Application {
        return application
    }

}