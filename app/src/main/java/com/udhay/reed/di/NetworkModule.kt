package com.udhay.reed.di

import com.google.gson.Gson
import com.udhay.reed.data.network.ApiService
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.core.annotation.Module
import org.koin.core.annotation.Single
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

@Module
class NetworkModule {

    @Single
    fun provideLoggingInterceptor() : HttpLoggingInterceptor{
        return HttpLoggingInterceptor().apply {
           level = HttpLoggingInterceptor.Level.BODY
        }
    }

    @Single
    fun provideHttpClient(loggingInterceptor: HttpLoggingInterceptor) : OkHttpClient{
        return OkHttpClient.Builder()
            .addInterceptor(loggingInterceptor)
            .build()
    }

    @Single
    fun provideRetrofit(httpClient: OkHttpClient): Retrofit{
        return Retrofit.Builder()
            .baseUrl("http://10.0.2.2:8080/")
            .client(httpClient)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    @Single
    fun provideApiService(retrofit: Retrofit) : ApiService{
        return retrofit.create(ApiService::class.java)
    }

    @Single
    fun provideGson() : Gson = Gson()
}