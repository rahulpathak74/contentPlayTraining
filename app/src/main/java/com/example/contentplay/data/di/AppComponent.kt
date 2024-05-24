package com.example.contentplay.data.di

import com.example.contentplay.data.api.RetrofitInstance
import dagger.Component

@Component(modules = [AppModule::class])
interface AppComponent {

    fun inject(retrofitInstance: RetrofitInstance)
}