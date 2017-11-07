package com.skynoff.smapp2018.ui.view.activities

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.design.widget.TextInputEditText
import android.view.MenuItem
import android.widget.Button
import android.widget.Toast
import com.skynoff.smapp2018.R
import com.skynoff.smapp2018.background.firebase.models.Users
import com.skynoff.smapp2018.ui.presenter.callbacks.RegisterCallback
import com.skynoff.smapp2018.ui.presenter.interactors.RegisterPresenter
import com.skynoff.smapp2018.ui.view.utils.TextValidator

class RegisterActivity : AppCompatActivity(), RegisterCallback.View {


    lateinit var name: TextInputEditText
    lateinit var lastName: TextInputEditText
    lateinit var email: TextInputEditText
    lateinit var password: TextInputEditText
    lateinit var seccion: TextInputEditText
    lateinit var alias: TextInputEditText
    lateinit var registerBt: Button
    lateinit var presenter: RegisterCallback.Presenter
     var user: Users=Users("","","",1,true,"")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setDisplayShowHomeEnabled(true)
        name = findViewById(R.id.tet_name)
        lastName = findViewById(R.id.tet_last_name)
        email = findViewById(R.id.tet_email)
        password = findViewById(R.id.tet_password)
        seccion = findViewById(R.id.tet_section)
        alias = findViewById(R.id.tet_section)
        registerBt = findViewById(R.id.bt_register)
        presenter = RegisterPresenter(this)


        registerBt.setOnClickListener {
            if (validateFields()) run {
                user.clave = password.text.toString()
                user.alias = alias.text.toString()
                user.email = email.text.toString()
                user.habilitado = true
                user.nivel = 1
                presenter.registerUser(user)


            }
        }

    }


    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        when (item?.itemId) {

            android.R.id.home -> onBackPressed()

        }
        return super.onOptionsItemSelected(item)


    }

    fun validateFields(): Boolean {

        return TextValidator.validateEmpty(listOf(name, password, email, lastName))

    }

    override fun showResults() {
        Toast.makeText(this, "Registrado", Toast.LENGTH_LONG).show()
        finish()
    }

    override fun showError() {
        Toast.makeText(this,"Fallo registro",Toast.LENGTH_LONG).show()
    }
}
