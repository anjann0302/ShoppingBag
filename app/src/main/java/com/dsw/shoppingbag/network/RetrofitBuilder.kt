package com.dsw.shoppingbag.network

import android.app.Application
import com.dsw.shoppingbag.BuildConfig
import com.dsw.shoppingbag.db.util.RemoteConfigVariables
import com.dsw.shoppingbag.utils.Util
import dagger.Module
import dagger.Provides
import okhttp3.Cache
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

/**
 * Class for configuring retrofit for network calls.
 * Configuration details to maintain in-memory retrofit cache is also maintained in this class
 */
@Module
class RetrofitBuilder {

    // Creates a retrofit object, along with OkHttpClient which is used to hit API
    @Provides
    fun getRetrofit(application: Application): ApiService {
        val cacheSize = (RemoteConfigVariables.CACHE_SIZE).toLong()
        val myCache = Cache(application.cacheDir, cacheSize)

        val okHttpClient = OkHttpClient.Builder()
            .cache(myCache)
            .addInterceptor { chain ->
                var request = chain.request()
                request = if (Util.hasNetwork(application)!!)
                    request.newBuilder().header(
                        "Cache-Control",
                        "public, max-age=" + RemoteConfigVariables.MAX_AGE
                    ).build()
                else
                    request.newBuilder().header(
                        "Cache-Control",
                        "public, only-if-cached, max-stale="
                                + RemoteConfigVariables.MAX_STALE_TIME
                    ).build()
                chain.proceed(request)
            }
            .build()

        return Retrofit.Builder()
            .baseUrl(BuildConfig.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .client(okHttpClient)
            .build()
            .create(ApiService::class.java)
    }

}