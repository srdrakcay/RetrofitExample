package com.serdar.myapplication

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface ApiService {


    @GET("horoscope-career/{sign}/{day}")
    //



    fun listPost(@Path("sign") sign: String,@Path("day") day:String,@Query("rapidapi-key") rapidapikey:String ="d81e046ef8mshd733e396e070d3dp1d5eb9jsn43059a236fcb" ): Call<HoroscopeModel>
}
