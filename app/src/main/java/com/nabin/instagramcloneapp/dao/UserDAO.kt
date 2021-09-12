package com.nabin.instagramcloneapp.dao

import androidx.room.*
import com.nabin.instagramcloneapp.entity.users

@Dao
interface UserDAO {

    @Insert
    suspend fun registerUser(user: users)

    @Update
    suspend fun updateUser(user:users)

    @Delete
    suspend fun deleteUser(user:users)

    @Query("select * from users where username=(:username) and password=(:password)")
    suspend fun checkUser(username: String, password: String): users
}