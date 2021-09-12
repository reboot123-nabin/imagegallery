package com.nabin.instagramcloneapp.api

import com.nabin.instagramcloneapp.entity.users
import com.nabin.instagramcloneapp.response.LoginResponse
import retrofit2.Response
import retrofit2.http.*


interface userAPI {
    //register user
    @POST("user/insert")

    suspend fun registerUser(
            @Body user: users
    ): Response<LoginResponse>
    @GET("user/all")
    suspend fun getAllUser(
            @Header("Authorization") token: String,
            // @Field("username") username: String,
            //@Field("password") password: String
    ): Response<LoginResponse>
    //login user
    @FormUrlEncoded
    @POST("user/login")

    suspend fun loginUser(
            @Field("username") username: String,
            @Field("password") password: String

    ): Response<LoginResponse>

    //for logout

    @POST("logout")
    suspend fun logout(
            @Header("Authorization") token: String
    ): Response<LoginResponse>

}