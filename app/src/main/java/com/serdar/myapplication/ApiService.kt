package com.serdar.myapplication

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {
    @GET("/sign={sign}&day={day}")

    fun listPost(@Query("sign") sign: String,@Query("day") day:String): Call<List<HoroscopeModel>>
}
