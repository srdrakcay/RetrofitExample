package com.serdar.myapplication


import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitInstance {
    private lateinit var retrofit: Retrofit

    fun getClient(): Retrofit {

        retrofit =
                Retrofit.Builder().baseUrl(Constant.baseUrl).addConverterFactory(GsonConverterFactory.create()).build()

        return retrofit as Retrofit
    }
}