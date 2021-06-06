package com.dieg0code.examplemvvm.core

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

// Retrofit implementation

// Retrofit is a library used for consume api's in android
object RetrofitHelper {
    fun getRetrofit(): Retrofit {
        return Retrofit.Builder()
            // Retrofit basic configuration
            .baseUrl("https://drawsomething-59328-default-rtdb.europe-west1.firebasedatabase.app/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }
}