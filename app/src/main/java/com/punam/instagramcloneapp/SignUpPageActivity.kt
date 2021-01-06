package com.punam.instagramcloneapp

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.*
import com.punam.instagramcloneapp.UserModel.UserProfileData

class SignUpPageActivity : AppCompatActivity() {

    private val batch = arrayOf("25A","25B","25C","25D","25E")
    private lateinit var   tvRegister : TextView
    private lateinit var   etCuID : EditText
    private lateinit var   etFirstName : EditText
    private lateinit var  etSecondName  : EditText
    private lateinit var etEmail: EditText
    private lateinit var    etSpinnerBatch : Spinner
    private lateinit var    etPassw : EditText
    private lateinit var   btnregister : Button
    var itemSelected=""
    private val listProfile=ArrayList<UserProfileData>();
    override fun onCreate(savedInstanceState: Bundle?) {
        getSupportActionBar()?.hide();
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_up_page)

        tvRegister = findViewById(R.id.tvRegister)
        etCuID = findViewById(R.id.etCuID)
        etFirstName = findViewById(R.id.etFirstName)
        etSecondName = findViewById(R.id.etSecondName)
        etEmail = findViewById(R.id.etEmail)
        etSpinnerBatch = findViewById(R.id.etSpinnerBatch)
        etPassw = findViewById(R.id.etPassw)
        btnregister = findViewById(R.id.btnregister)
        
        val adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, batch)
      
        etSpinnerBatch.adapter = adapter

        etSpinnerBatch.onItemSelectedListener=
                object: AdapterView.OnItemSelectedListener{
                    override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
                       val selectedItem = parent?.getItemAtPosition(position).toString()
                    }

                    override fun onNothingSelected(parent: AdapterView<*>?) {
                    }
                }
        btnregister.setOnClickListener{
            val id=etCuID.text.toString()
            val profile=UserProfileData(id.toInt(),etFirstName.text.toString(),etSecondName.text.toString()
                    ,etEmail.text.toString(),etPassw.text.toString(),itemSelected)
            Toast.makeText(this,"Registration Successful",Toast.LENGTH_SHORT).show()


            val intent=Intent()
            intent.putExtra("userprofilelist",profile)
            setResult(Activity.RESULT_OK,intent)
            finish()
        }
    }
}