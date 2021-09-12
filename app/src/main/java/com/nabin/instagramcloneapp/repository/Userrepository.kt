package com.nabin.instagramcloneapp.repository

import com.nabin.instagramcloneapp.api.MyApiRequest
import com.nabin.instagramcloneapp.api.ServiceBuilder
import com.nabin.instagramcloneapp.api.userAPI
import com.nabin.instagramcloneapp.entity.users
import com.nabin.instagramcloneapp.response.LoginResponse


class Userrepository: MyApiRequest() {

    private val UserAPI = ServiceBuilder.buildService(userAPI::class.java)

    //register user
    suspend fun registerUser(user: users) : LoginResponse {
        return apiRequest{
            UserAPI.registerUser(user)
        }
    }

    //login user
    suspend fun loginUser(username: String, password: String) : LoginResponse{
        return apiRequest{
            UserAPI.loginUser(username,password)
        }
    }
    suspend fun getAllUser(): LoginResponse {
        return apiRequest {
            UserAPI.getAllUser(
                ServiceBuilder.token!!

            )
        }

    }

    //for logout

    suspend fun logout():LoginResponse{
        return apiRequest {
            UserAPI.logout(ServiceBuilder.token!!)
        }
    }
}