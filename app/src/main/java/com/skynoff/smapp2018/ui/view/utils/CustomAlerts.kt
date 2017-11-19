package com.skynoff.smapp2018.ui.view.utils

import android.app.Activity
import android.app.AlertDialog
import android.content.Context
import android.content.DialogInterface
import android.content.Intent
import android.util.Log
import com.google.firebase.firestore.FirebaseFirestore
import com.skynoff.smapp2018.ui.view.activities.MainActivity

/**
 * Created by cesar.smith on 11/5/2017.
 */
class CustomAlerts {
    companion object {


        lateinit var alert: AlertDialog.Builder

        fun alertDeleteAsig(context: Context, id: String) {
            val db = FirebaseFirestore.getInstance()
            val act: Activity = context as Activity
            alert = AlertDialog.Builder(context)
            alert.setTitle("Atencion!").setMessage("Esta a punto de eliminar una asignacion, ¿Esta seguro que desea continuar?")
            alert.setPositiveButton("Si", DialogInterface.OnClickListener { dialog, whichButton ->
                db.collection("asignaciones").document(id).delete().addOnCompleteListener {
                    Log.e("Eliminado", "Correcto")
                    context.startActivity(Intent(context, MainActivity::class.java))
                    act.finish()
                }
            }).setNegativeButton("No", null).create().show()

        }



    }
}