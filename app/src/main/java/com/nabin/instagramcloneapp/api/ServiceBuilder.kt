package com.nabin.instagramcloneapp.api

import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


object ServiceBuilder {
//    private const val BASE_URL = "http://10.0.2.2:3000/"
//
    private const val BASE_URL = "http://192.168.100.4:3000/"
//    private const val BASE_URL = "http://localhost:3000/"
    //private const val BASE_URL = "mongodb://127.0.0.1:27017/bussystem"
    var token : String? =null
    //    private val okHttp = OkHttpClient.Builder().callTimeout(20, TimeUnit.SECONDS).readTimeout(20, TimeUnit.SECONDS)
//            .writeTimeout(20, TimeUnit.SECONDS)
    private val okHttp= OkHttpClient.Builder()
    //create retrofit builder
    private val retrofitBuilder = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .client(okHttp.build())

    //create retrofit instance
    private val retrofit = retrofitBuilder.build()

    //generic function
    fun <T> buildService(serviceType: Class<T>):T{
        return retrofit.create(serviceType)
    }

    // Load image path in Service Builder class
//    fun loadImagePath(): String {
//        val arr = BASE_URL.split("/").toTypedArray()
//        return arr[0] + "/" + arr[1] + arr[2] + "/uploads/"
//    }

    fun loadImagePath(): String {
//        val arr = BASE_URL.split("/").toTypedArray()
//        return arr[0] + "/" + arr[1] + arr[2] + "/uploads/"
        return BASE_URL
    }
}