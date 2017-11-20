package com.skynoff.smapp2018.ui.view.activities

import android.os.Bundle
import android.support.design.widget.TextInputEditText
import android.support.v7.app.AppCompatActivity
import android.widget.Button
import android.widget.Spinner
import com.skynoff.smapp2018.R
import com.skynoff.smapp2018.ui.presenter.callbacks.CrearAsignacionCallback
import com.skynoff.smapp2018.ui.presenter.interactors.CrearAsignacionPresenter
import com.skynoff.smapp2018.ui.view.utils.CustomSpinners
import com.skynoff.smapp2018.ui.view.utils.PickersDialogs
import org.jetbrains.anko.longToast

class CrearAsignacionActivity : AppCompatActivity(), CrearAsignacionCallback.View {


    lateinit var descripcion: TextInputEditText
    lateinit var fecha: TextInputEditText
    lateinit var nombre: TextInputEditText
    lateinit var puntaje: TextInputEditText
    lateinit var asignatura: TextInputEditText
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
        descripcion = findViewById(R.id.tet_descripcion)
        fecha = findViewById(R.id.tet_date)
        nombre = findViewById(R.id.tet_name)
        puntaje = findViewById(R.id.tet_value)
        asignatura = findViewById(R.id.tet_asignatura)
        seccion = findViewById(R.id.tet_section)
        tipo = findViewById(R.id.tet_evaluation_type)
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
        asignatura.setOnClickListener{
            CustomSpinners.asignaturaSpinner(this,asignatura)
        }

        tipo.setOnClickListener {
           CustomSpinners.tipoExamenSpinner(this,tipo)
        }
        fecha.setOnClickListener {
            PickersDialogs.setEvalDate(this,fecha)
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
