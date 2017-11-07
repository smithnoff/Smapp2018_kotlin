package com.skynoff.smapp2018.ui.model

import android.util.Log
import com.google.firebase.firestore.FirebaseFirestore
import com.skynoff.smapp2018.ui.presenter.callbacks.CrearAsignacionCallback

/**
 * Created by cesar.smith on 11/4/2017.
 */
class CrearAsignacionModel(var presenter: CrearAsignacionCallback.Presenter) : CrearAsignacionCallback.Model {


    override fun setCreateAsign(asignacion: HashMap<String, Any>) {
        val db = FirebaseFirestore.getInstance()

        db.collection("asignaciones").add(asignacion).addOnCompleteListener {
            Log.e("status:", "guardado")
            presenter.showResults()
        }.addOnFailureListener {
            Log.e("status:", "fallo")
            presenter.showErrors()
        }
    }
}