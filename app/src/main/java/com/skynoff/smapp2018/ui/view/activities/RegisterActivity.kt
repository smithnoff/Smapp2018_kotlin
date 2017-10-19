package com.skynoff.smapp2018.ui.view.activities

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.design.widget.TextInputEditText
import android.view.MenuItem
import android.widget.Button
import com.skynoff.smapp2018.R
import com.skynoff.smapp2018.ui.view.utils.TextValidator

class RegisterActivity : AppCompatActivity() {
      lateinit var name: TextInputEditText
      lateinit var lastName: TextInputEditText
      lateinit var email: TextInputEditText
      lateinit var password: TextInputEditText
      lateinit var seccion: TextInputEditText
      lateinit var alias: TextInputEditText
      lateinit var registerBt: Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setDisplayShowHomeEnabled(true)
        name=findViewById(R.id.tet_name)
        lastName=findViewById(R.id.tet_last_name)
        email=findViewById(R.id.tet_email)
        password=findViewById(R.id.tet_password)
        seccion=findViewById(R.id.tet_section)
        alias=findViewById(R.id.tet_section)
        registerBt=findViewById(R.id.bt_register)

      registerBt.setOnClickListener{validateFields()}

    }


    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
         when(item?.itemId){

             android.R.id.home->onBackPressed()

         }
         return super.onOptionsItemSelected(item)


    }

    fun validateFields(){

        TextValidator.validateEmpty(listOf(name,password,email,lastName))

    }

}
