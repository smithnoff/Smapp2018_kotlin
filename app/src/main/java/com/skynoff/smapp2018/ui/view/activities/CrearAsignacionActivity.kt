package com.skynoff.smapp2018.ui.view.activities

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.design.widget.TextInputEditText
import android.util.Log
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.Spinner
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.SetOptions
import com.skynoff.smapp2018.R
import com.skynoff.smapp2018.R.id.snap
import com.skynoff.smapp2018.background.database.SQLiteHelper
import com.skynoff.smapp2018.ui.presenter.callbacks.CrearAsignacionCallback
import com.skynoff.smapp2018.ui.presenter.interactors.CrearAsignacionPresenter
import org.jetbrains.anko.longToast

class CrearAsignacionActivity : AppCompatActivity(), CrearAsignacionCallback.View {


    lateinit var descripcion: TextInputEditText
    lateinit var fecha: TextInputEditText
    lateinit var nombre: TextInputEditText
    lateinit var puntaje: TextInputEditText
    lateinit var seccion: TextInputEditText
    lateinit var tipo: TextInputEditText
    lateinit var registerBt: Button
    lateinit var tipoEval: Spinner
    lateinit var presenter: CrearAsignacionCallback.Presenter
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
        tipoEval = findViewById(R.id.sp_tipo_eval)
        registerBt = findViewById(R.id.bt_register)
        presenter = CrearAsignacionPresenter(this)

        registerBt.setOnClickListener {
            val asignacion: HashMap<String, Any> = HashMap<String, Any>()

            asignacion.put("descripcion", descripcion.text.toString())
            asignacion.put("fecha", fecha.text.toString())
            asignacion.put("nombre", nombre.text.toString())
            asignacion.put("puntaje", puntaje.text.toString().toInt())
            asignacion.put("seccion", seccion.text.toString().toInt())
            asignacion.put("tipo", tipoEval.selectedItem.toString())
            presenter.createAsign(asignacion)
        }
       val db=FirebaseFirestore.getInstance()
        db.collection("tipo_examen").get().addOnCompleteListener {
            val sqdb=SQLiteHelper.getInstance(this)
/*
            val adp= ArrayAdapter(this,android.R.layout.simple_spinner_item,it.result.documents.toList())
*/
            val adp= ArrayAdapter(this,R.layout.item_spinner,sqdb.getTipoExamen())
            tipoEval.adapter=adp
        }
    }

    override fun showResults() {
        longToast("Guardado")
        finish()
    }

    override fun showErrors() {
        longToast("No se pudo guardar la asignacion")
    }
}
