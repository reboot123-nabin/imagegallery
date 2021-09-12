package com.nabin.instagramcloneapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import com.nabin.instagramcloneapp.databinding.ActivityRegisterBinding
import com.nabin.instagramcloneapp.db.UserDB
import com.nabin.instagramcloneapp.entity.users
import com.nabin.instagramcloneapp.repository.Userrepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import java.lang.Exception

class RegisterActivity : AppCompatActivity() {
    lateinit var binding: ActivityRegisterBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)
        binding=ActivityRegisterBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.submit.setOnClickListener {
            form()

        }
    }
    private fun form(){

        val username1 = binding.username.text.toString()
        val password1 = binding.password.text.toString()
        val confirmPassword1 = binding.tvconfirmpassword.text.toString()

        if (password1 != confirmPassword1) {
            binding.password.error = "Password does not match"
            binding.password.requestFocus()


        } else {
            val user =
                users( username = username1, password = password1)

            CoroutineScope(Dispatchers.IO).launch {
                try {

//                     Switch to Main thread
//                    withContext(Main){
//                        Toast.makeText(this@SignUpActivity, "user registered", Toast.LENGTH_SHORT).show()
//                    }
                    val userRepository = Userrepository()
                    val response = userRepository.registerUser(user)

                    if (response.message != null) {
                        withContext(Dispatchers.Main) {
                            Toast.makeText(
                                this@RegisterActivity,
                                "You have successfully signup",
                                Toast.LENGTH_SHORT
                            ).show()
                            startActivity(
                                Intent(
                                    this@RegisterActivity,
                                    LoginActivity::class.java
                                )
                            )
                        }
                    }
                } catch (ex: Exception){
                    withContext(Dispatchers.Main){
                        Toast.makeText(this@RegisterActivity,ex.toString(),
                            Toast.LENGTH_SHORT).show()
                    }
                }

            }

        }
    }

}