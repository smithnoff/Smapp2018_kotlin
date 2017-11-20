package com.skynoff.smapp2018.ui.view.utils

import android.app.Activity
import android.app.Dialog
import android.support.design.widget.TextInputEditText
import android.view.Window
import android.widget.ArrayAdapter
import android.widget.ListView
import android.widget.TextView
import com.skynoff.smapp2018.R
import com.skynoff.smapp2018.background.database.SQLiteHelper

/**
 * Created by cesar on 18/11/17.
 */
class CustomSpinners {


    companion object {
        fun tipoExamenSpinner(activity: Activity, input: TextInputEditText) {
            val dialog = Dialog(activity)
            dialog.requestWindowFeature(Window.FEATURE_NO_TITLE)
            dialog.setContentView(R.layout.dialog_custom_spinner)


            var titulo = dialog.findViewById<TextView>(R.id.dialog_title)
            var lista = dialog.findViewById<ListView>(R.id.dialog_list)

            titulo.setText("Seleccione ")
            lista.adapter = ArrayAdapter<String>(activity, android.R.layout.select_dialog_item, SQLiteHelper.getInstance(activity).getTipoExamen())
            lista.setOnItemClickListener { adapterView, view, i, l ->
                input.setText(adapterView.getItemAtPosition(i).toString())
                dialog.dismiss()
            }

            dialog.show()
        }

        fun asignaturaSpinner(activity: Activity, editText: TextInputEditText?) {
            val dialog = Dialog(activity)
            dialog.requestWindowFeature(Window.FEATURE_NO_TITLE)
            dialog.setContentView(R.layout.dialog_custom_spinner)


            var titulo = dialog.findViewById<TextView>(R.id.dialog_title)
            var lista = dialog.findViewById<ListView>(R.id.dialog_list)

            titulo.setText("Seleccione ")
            lista.adapter = ArrayAdapter<String>(activity, android.R.layout.select_dialog_item, SQLiteHelper.getInstance(activity).getAsignaturas())
            lista.setOnItemClickListener { adapterView, view, i, l ->
                editText?.setText(adapterView.getItemAtPosition(i).toString())
                dialog.dismiss()
            }

            dialog.show()
        }
    }


}