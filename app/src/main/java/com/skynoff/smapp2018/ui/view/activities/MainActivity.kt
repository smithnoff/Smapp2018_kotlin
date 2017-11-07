package com.skynoff.smapp2018.ui.view.activities

import android.os.Bundle
import android.support.design.widget.BottomNavigationView
import android.support.v7.app.AppCompatActivity
import com.skynoff.smapp2018.R
import com.skynoff.smapp2018.ui.view.fragments.AsignacionFragment
import com.skynoff.smapp2018.ui.view.fragments.EjerciciosFragment
import com.skynoff.smapp2018.ui.view.fragments.NivelLeccionesFragment
import kotlinx.android.synthetic.main.activity_main.*
import com.google.firebase.firestore.FirebaseFirestoreSettings
import com.skynoff.smapp2018.background.database.SQLiteHelper


class MainActivity : AppCompatActivity() {
    lateinit var fragment:android.support.v4.app.Fragment
    lateinit var transaction:android.support.v4.app.FragmentTransaction

    private val mOnNavigationItemSelectedListener = BottomNavigationView.OnNavigationItemSelectedListener { item ->
        transaction=supportFragmentManager.beginTransaction()
        when (item.itemId) {
            R.id.navigation_home -> {
                fragment=AsignacionFragment()
                transaction.replace(R.id.fragment_container,fragment)
                transaction.commit()
                return@OnNavigationItemSelectedListener true
            }
            R.id.navigation_dashboard -> {
                fragment= NivelLeccionesFragment()
                transaction.replace(R.id.fragment_container,fragment)
                transaction.commit()
                return@OnNavigationItemSelectedListener true
            }
            R.id.navigation_notifications -> {
                fragment= EjerciciosFragment()
                transaction.replace(R.id.fragment_container,fragment)
                transaction.commit()
                return@OnNavigationItemSelectedListener true
            }
        }
        false
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        fragment=AsignacionFragment()
        transaction=supportFragmentManager.beginTransaction()
        transaction.replace(R.id.fragment_container,fragment)
        transaction.commit()
        val manager=SQLiteHelper.getInstance(this)
        manager.getTipoExamen()
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener)
    }
}
