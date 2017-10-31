package com.skynoff.smapp2018.ui.model

import com.google.firebase.firestore.FirebaseFirestore
import com.skynoff.smapp2018.background.firebase.models.Users
import com.skynoff.smapp2018.ui.presenter.callbacks.RegisterCallback

/**
 * Created by cesar.smith on 10/18/2017.
 */
class RegisterModel : RegisterCallback.Model {
       var db:FirebaseFirestore

    var presenter:RegisterCallback.Presenter

    constructor(presenter: RegisterCallback.Presenter) {
        this.presenter = presenter
        db= FirebaseFirestore.getInstance()
    }
    override fun registerUser(user: Users) {

        var map :HashMap<String,Any> = hashMapOf()
        map.put("tipo",user.alias)
        map.put("clave",user.clave)
        map.put("correo",user.email)
        map.put("habilitado",user.habilitado)
        map.put("nivel",user.nivel)

        db.collection("usuarios").document().set(map).addOnCompleteListener {
            presenter.showResults()
        }.addOnFailureListener {
            presenter.showError()
        }





    }
}