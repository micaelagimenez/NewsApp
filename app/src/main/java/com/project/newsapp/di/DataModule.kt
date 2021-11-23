package com.project.newsapp.di

import com.project.newsapp.BuildConfig.API_URL
import com.project.newsapp.data.jp.JapaneseDataSource
import com.project.newsapp.data.jp.JapaneseService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

@Module
@InstallIn(SingletonComponent::class)
class DataModule {

    @ApiNews
    @Provides
    fun provideRetrofit(okHttpClient: OkHttpClient) = Retrofit.Builder()
        .baseUrl(API_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .client(okHttpClient)
        .build()

    @Provides
    fun provideOkHttpClient() = OkHttpClient.Builder()
        .addInterceptor(HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY))
        .build()

    @Provides
    fun provideJapaneseService(@ApiNews retrofit: Retrofit) =
        retrofit.create(JapaneseService::class.java)

    @Provides
    fun provideJapaneseDataSource(japaneseService: JapaneseService): JapaneseDataSource {
        return JapaneseDataSource(japaneseService)
    }
}