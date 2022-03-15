package com.allaykhalil.apicallingwithcoroutinesandhilt.di.module

import com.allaykhalil.apicallingwithcoroutinesandhilt.utils.Constants
import com.allaykhalil.apicallingwithcoroutinesandhilt.data.remote.ApiService
import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

/**
 * Created by Allay on 3/15/2022
 */
@Module
@InstallIn(SingletonComponent::class)
class ApplicationModule {

  /*  preferencesHelper: PreferencesHelper*/
    @Singleton
    @Provides
    fun provideRetrofitService(): ApiService =
        Retrofit.Builder()
            .baseUrl(Constants.API_BASE_PATH)
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(CoroutineCallAdapterFactory())
            .client(ApiHttpClient().getHTTPClient())
            .build()
            .create(ApiService::class.java)
}