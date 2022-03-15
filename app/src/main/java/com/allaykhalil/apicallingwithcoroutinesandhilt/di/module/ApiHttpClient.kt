package com.allaykhalil.apicallingwithcoroutinesandhilt.di.module

import okhttp3.OkHttpClient
import java.util.concurrent.TimeUnit


class ApiHttpClient {
    fun getHTTPClient(): OkHttpClient {
        val httpClient = OkHttpClient.Builder()
            .connectTimeout(40, TimeUnit.SECONDS)
            .readTimeout(40, TimeUnit.SECONDS)
            .writeTimeout(40, TimeUnit.SECONDS)

        httpClient.addInterceptor { chain ->
            val request = chain.request()
            // TODO: 4/25/2021 After saving the user authToken at Preferences, get the token for api calling and pass it as a header.
            chain.proceed(/*preferencesHelper.getAccessToken().let {
                request.newBuilder().addHeader(
                    "token",
                    it
                ).build()
            } ?: run {

            }*/
                request
            )
        }

        return httpClient.build()
    }
}
