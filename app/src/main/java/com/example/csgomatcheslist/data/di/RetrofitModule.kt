package com.example.csgomatcheslist.data.di

import com.example.csgomatcheslist.BuildConfig.DEBUG
import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

private fun retrofit(okHttpClient: OkHttpClient) = Retrofit.Builder()
    .baseUrl("")
    .addConverterFactory(GsonConverterFactory.create())
    .addCallAdapterFactory(CoroutineCallAdapterFactory())
    .client(okHttpClient)
    .build()

fun providesOkHttpClient(interceptor: HttpLoggingInterceptor): OkHttpClient {
    return OkHttpClient.Builder()
        .connectTimeout(60L, TimeUnit.SECONDS)
        .readTimeout(60L, TimeUnit.SECONDS)
        .addInterceptor(interceptor).build()
}

private fun providesHttplogging(): HttpLoggingInterceptor {
    val interceptor = HttpLoggingInterceptor()
    interceptor.level = if (DEBUG)
        HttpLoggingInterceptor.Level.BODY
    else
        HttpLoggingInterceptor.Level.NONE
    return interceptor
}

