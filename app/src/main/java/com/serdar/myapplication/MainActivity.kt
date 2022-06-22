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



        val post = postService.listPost("virgo","tomorrow","d81e046ef8mshd733e396e070d3dp1d5eb9jsn43059a236fcb")

            post.enqueue(object : Callback<HoroscopeModel> {


                override fun onFailure(call: Call<HoroscopeModel>, t: Throwable) {
                    Toast.makeText(applicationContext, t.message.toString(), Toast.LENGTH_LONG).show()

                }

                override fun onResponse(call: Call<HoroscopeModel>, response: Response<HoroscopeModel>) {



                        if (response.isSuccessful ) {



                            Toast.makeText(this@MainActivity, "Data", Toast.LENGTH_SHORT).show()

                            // postList = (response.body() as MutableList<HoroscopeModel>)
                            textView8.text=response.body().toString()

                        }else{
                            Toast.makeText(this@MainActivity, "No Data", Toast.LENGTH_SHORT).show()


                        }



                }



            })
        }
    }



