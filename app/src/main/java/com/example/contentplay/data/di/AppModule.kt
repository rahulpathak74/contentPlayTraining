package com.example.contentplay.data.di

import com.example.contentplay.BuildConfig
import com.example.contentplay.data.api.ContentPlayApiInterface
import com.example.contentplay.data.api.RetrofitInstance
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

@Module
class AppModule {

    /*Retrofit instance will be created and here and injected. Later we can use same instance anywhere in app*/

    @Provides
    fun providesContentPlayAPIInterface(): ContentPlayApiInterface{
        val logging = HttpLoggingInterceptor()
        logging.level = HttpLoggingInterceptor.Level.BODY

        val client = OkHttpClient.Builder()
            .connectTimeout(10, TimeUnit.SECONDS)
            .readTimeout(10, TimeUnit.SECONDS)
            .writeTimeout(10, TimeUnit.SECONDS)
            .addInterceptor(logging)
            .build()

        return Retrofit.Builder()
            .baseUrl(BuildConfig.BASE_URL)
            .client(client)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(ContentPlayApiInterface::class.java)
    }

    @Provides
    fun provideRetrofitInstance(): RetrofitInstance {
        return RetrofitInstance()
    }
}