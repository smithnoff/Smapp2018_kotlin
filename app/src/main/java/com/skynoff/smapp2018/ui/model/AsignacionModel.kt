package com.skynoff.smapp2018.ui.model

import android.util.Log
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.FirebaseFirestoreSettings
import com.skynoff.smapp2018.background.firebase.models.Assignments
import com.skynoff.smapp2018.ui.presenter.callbacks.AsignacionCallback

/**
 * Created by cesar.smith on 10/20/2017.
 */
class AsignacionModel(var presenter: AsignacionCallback.Presenter) : AsignacionCallback.Model {
    private var db: FirebaseFirestore = FirebaseFirestore.getInstance()
    var settings = FirebaseFirestoreSettings.Builder()
            .setPersistenceEnabled(true)
            .build()
    var list: MutableList<Assignments> = mutableListOf()


    override fun getAsignments() {

        db.firestoreSettings = settings
        db.collection("asignaciones").get().addOnSuccessListener { snapshot ->
            for (document in snapshot.documents) {
                Log.e("Aqui el doc: ", document["nombre"].toString())

                list.add(Assignments(document.id,document["descripcion"].toString()
                        , document["fecha"].toString(),
                        document["nombre"].toString(),
                        (document["puntaje"] as Long).toInt(),
                        document["tipo"].toString(),
                        document["seccion"].toString()))
            }
            presenter.startasignments(list)
        }
    }

}