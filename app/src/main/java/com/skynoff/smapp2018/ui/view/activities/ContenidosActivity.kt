package com.skynoff.smapp2018.ui.view.activities

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Log
import android.widget.TextView
import com.google.firebase.firestore.FirebaseFirestore
import com.skynoff.smapp2018.R

class ContenidosActivity : AppCompatActivity() {
    lateinit var contenido: TextView
    lateinit var db: FirebaseFirestore
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_contenidos)
        db = FirebaseFirestore.getInstance()
        val idContent: String = intent.extras.getString("lecId")
        contenido = findViewById(R.id.tv_contenido)

        db.collection("contenido").get().addOnCompleteListener {
            snap ->
            Log.e( "id", idContent.toString())
            snap.result
                    .filter { idContent== it["id"].toString() }
                    .forEach { contenido.text = it["descripcion"].toString() }
        }.addOnFailureListener {

            contenido.text = "No se encontro la leccion"

        }

    }
}
