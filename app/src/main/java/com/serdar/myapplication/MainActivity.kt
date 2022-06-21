package com.serdar.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.lifecycle.MutableLiveData
import kotlinx.android.synthetic.main.activity_main.*
import okhttp3.OkHttpClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {
    lateinit var postService: ApiService
    lateinit var postList: MutableList<HoroscopeModel>
    lateinit var data:HoroscopeModel


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        postService = RetrofitInstance.getClient().create(ApiService::class.java)


        val post = postService.listPost("virgo","tomorrow")
        post.enqueue(object : Callback<List<HoroscopeModel>> {


            override fun onFailure(call: Call<List<HoroscopeModel>>, t: Throwable) {
                Toast.makeText(applicationContext, t.message.toString(), Toast.LENGTH_LONG).show()

        }

            override fun onResponse(call: Call<List<HoroscopeModel>>, response: Response<List<HoroscopeModel>>) {



                    if (response.isSuccessful) {



                      Toast.makeText(this@MainActivity, "Data", Toast.LENGTH_SHORT).show()

                        postList = (response.body() as MutableList<HoroscopeModel>)
                        textView.text=response.body().toString()

                    }else{
                      Toast.makeText(this@MainActivity, "No Data", Toast.LENGTH_SHORT).show()


                    }
                }


        })
    }



}