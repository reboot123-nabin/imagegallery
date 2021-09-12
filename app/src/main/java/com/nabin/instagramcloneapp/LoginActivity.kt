package com.nabin.instagramcloneapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.google.android.material.snackbar.Snackbar
import com.nabin.instagramcloneapp.api.ServiceBuilder
import com.nabin.instagramcloneapp.databinding.ActivityLoginBinding
import com.nabin.instagramcloneapp.repository.Userrepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import java.io.IOException

class LoginActivity : AppCompatActivity() {
    private lateinit var binding: ActivityLoginBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.btnlogin.setOnClickListener {

            login()


        }
        binding.etSignup.setOnClickListener {
            startActivity(
                Intent(
                    this@LoginActivity,
                   RegisterActivity::class.java
                )
            )
        }


    }

    private fun login() {
        val username = binding.tvusername.text.toString()
        val password = binding.tvpassword.text.toString()




        CoroutineScope(Dispatchers.IO).launch {
            try {
                val repository = Userrepository()
                val response = repository.loginUser(username, password)
                if (response.message != null) {
                    withContext(Dispatchers.Main) {
                        ServiceBuilder.token = "Bearer ${response.token}"
                        //Toast.makeText(this@LoginActivity, response.token, Toast.LENGTH_LONG).show()

                        Toast.makeText(
                            this@LoginActivity,
                            "You have successfully login",
                            Toast.LENGTH_SHORT
                        ).show()

                        startActivity(
                            Intent(
                                this@LoginActivity,
                                HomePageActivity::class.java
                            )
                        )
                        finish()
                    }

                } else {
                    withContext(Dispatchers.Main) {
                        val snack =
                            Snackbar.make(
                                binding.linearlayout,
                                "Invalid credentials",
                                Snackbar.LENGTH_LONG
                            )
                        snack.setAction("OK", View.OnClickListener {
                            snack.dismiss()
                        })
                        snack.show()
                    }
                }
            } catch (ex: IOException) {
                withContext(Dispatchers.Main) {
                    Toast.makeText(
                        this@LoginActivity,
                        "login failed",
                        Toast.LENGTH_SHORT
                    ).show()
                }
            }

        }
    }
}