package com.example.csgomatcheslist.data.di

import com.example.csgomatcheslist.BuildConfig.BASE_URL
import com.example.csgomatcheslist.BuildConfig.DEBUG
import com.example.csgomatcheslist.data.remote.api.Api
import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class RetrofitModule {



    @Singleton
    @Provides
    fun provideRetrofitInstance(retrofit: Retrofit) :
            Api = retrofit.create(Api::class.java)

    @Singleton
    @Provides
    fun retrofit(okHttpClient: OkHttpClient) = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .addCallAdapterFactory(CoroutineCallAdapterFactory())
        .client(okHttpClient)
        .build()



    @Singleton
    @Provides
    fun providesOkHttpClient(interceptor: HttpLoggingInterceptor): OkHttpClient {
        return OkHttpClient.Builder()
            .connectTimeout(60L, TimeUnit.SECONDS)
            .readTimeout(60L, TimeUnit.SECONDS)
            .addInterceptor(interceptor).build()
    }


    @Singleton
    @Provides
    fun providesHttpLogging(): HttpLoggingInterceptor {
        val interceptor = HttpLoggingInterceptor()
        interceptor.level = if (DEBUG)
            HttpLoggingInterceptor.Level.BODY
        else
            HttpLoggingInterceptor.Level.NONE
        return interceptor
    }
}

