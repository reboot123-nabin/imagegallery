package com.nabin.instagramcloneapp

import com.nabin.instagramcloneapp.entity.users
import com.nabin.instagramcloneapp.repository.Userrepository
import kotlinx.coroutines.runBlocking
import org.junit.Assert
import org.junit.Test

class InstagramTest {
    private lateinit var userRepository: Userrepository
    @Test
    fun checkLogin() = runBlocking {
        userRepository = Userrepository()
        val response = userRepository.loginUser("luffy", "onepiece")
        val expectedResult = "auth successful"
        val actualResult = response.message
        Assert.assertEquals(expectedResult, actualResult)
    }
    @Test
    fun registerUser() = runBlocking {
        val user =
                users( username = "luffy", password = "onepiece")
        userRepository = Userrepository()
        val response = userRepository.registerUser(user)
        val expectedResult = "registered successful"
        val actualResult = response.message
        Assert.assertEquals(expectedResult, actualResult)
    }
}