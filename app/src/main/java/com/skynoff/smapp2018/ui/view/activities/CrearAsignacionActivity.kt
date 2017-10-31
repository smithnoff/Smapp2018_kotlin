package com.skynoff.smapp2018.ui.view.activities

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.design.widget.TextInputEditText
import android.util.Log
import android.widget.Button
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.SetOptions
import com.skynoff.smapp2018.R

class CrearAsignacionActivity : AppCompatActivity() {
    lateinit var descripcion: TextInputEditText
    lateinit var fecha: TextInputEditText
    lateinit var nombre: TextInputEditText
    lateinit var puntaje: TextInputEditText
    lateinit var seccion: TextInputEditText
    lateinit var tipo: TextInputEditText
    lateinit var registerBt: Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_crear_asignacion)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setDisplayShowHomeEnabled(true)
        descripcion = findViewById(R.id.tet_name)
        fecha = findViewById(R.id.tet_last_name)
        nombre = findViewById(R.id.tet_email)
        puntaje = findViewById(R.id.tet_password)
        seccion = findViewById(R.id.tet_section)
        tipo = findViewById(R.id.tet_section)
        registerBt = findViewById(R.id.bt_register)

        registerBt.setOnClickListener {
            val db =FirebaseFirestore.getInstance()
            var asignacion:HashMap<String,Any> =HashMap<String,Any>()

            asignacion.put("descripcion",descripcion.text.toString())
            asignacion.put("fecha",fecha.text.toString())
            asignacion.put("nombre",nombre.text.toString())
            asignacion.put("puntaje",  puntaje.text.toString().toInt() )
            asignacion.put("seccion",seccion.text.toString().toInt() )
            asignacion.put("tipo",tipo.text.toString())
            db.collection("asignaciones").add(asignacion).addOnCompleteListener{
                Log.e("status:","guardado")
            }.addOnFailureListener{
                Log.e("status:","fallo")

            }

        }


    }
}