package com.nabin.instagramcloneapp

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.*
import com.nabin.instagramcloneapp.UserModel.UserProfileData


class StartPageActivity : AppCompatActivity() {

   lateinit var name: String
    private lateinit var instaImg : ImageView
    private lateinit var etEmail : EditText
    private lateinit var etPassword : EditText
    private lateinit var  tvforrgetpass : TextView
    private lateinit var btnIdLogin : Button
    private lateinit var etSignup: TextView
    var etemail:String="";
    var etpassw:String="";

    var etCuID=""
//    var img:String=""
    val userlist= arrayListOf<UserProfileData>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_start_page)

        instaImg = findViewById(R.id.instaImg)
        etEmail =  findViewById(R.id.etEmail)
        etPassword =  findViewById(R.id.etPassword)
        tvforrgetpass =  findViewById(R.id.tvforrgetpass)
        btnIdLogin =  findViewById(R.id.btnIdlogin)
        etSignup =  findViewById(R.id.etSignup)


        btnIdLogin.setOnClickListener {
            if (etEmail.text.toString() == etemail && etPassword.text.toString() == etpassw) {
                val intent=Intent(this, HomePageActivity::class.java)
                intent.putExtra("name",name)
                intent.putExtra("cid",etCuID)
                startActivity(intent)
                Toast.makeText(this, "Welcome $name", Toast.LENGTH_SHORT).show()
            } else {
                Toast.makeText(this, "Please Enter valid email and password", Toast.LENGTH_LONG)
                        .show()
            }
        }
        etSignup.setOnClickListener{
            val req=1
            startActivityForResult(Intent(this,SignUpPageActivity::class.java),req)

        }

    }
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if(requestCode==1){
            if(resultCode== Activity.RESULT_OK) {
                var profile= data?.getParcelableExtra<UserProfileData>("userprofilelist")
                userlist.add(profile!!)
                etCuID=userlist.get(0).cuid.toString()
                etemail=userlist.get(0).email.toString()
                etpassw=userlist.get(0).password.toString()
                val fname=userlist.get(0).fname.toString()
                val lname=userlist.get(0).lname.toString()
                name="$fname $lname"
            }
        }
    }
}