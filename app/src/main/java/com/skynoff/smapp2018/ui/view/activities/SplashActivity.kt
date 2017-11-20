package com.skynoff.smapp2018.ui.view.activities

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.support.v7.app.AppCompatActivity
import com.skynoff.smapp2018.R
import com.skynoff.smapp2018.background.database.SQLiteHelper

class SplashActivity : AppCompatActivity() {
    internal var SPLASH_TIME_OUT = 2000


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)
        var manager = SQLiteHelper(this)
        //manager.deleteTipoEx()
        manager.insertData()
        manager.insertSecciones()
        Handler().postDelayed(
                {
                    startActivity(Intent(this, LoginActivity::class.java))
                    finish()
                }, SPLASH_TIME_OUT.toLong())
    }
}
