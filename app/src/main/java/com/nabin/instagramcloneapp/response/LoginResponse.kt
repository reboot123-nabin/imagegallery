package com.nabin.instagramcloneapp.response

import com.nabin.instagramcloneapp.entity.users

data class LoginResponse (
    val message: String? = null,
    val token: String? = null,
    val data: MutableList<users>? = null,
){

}