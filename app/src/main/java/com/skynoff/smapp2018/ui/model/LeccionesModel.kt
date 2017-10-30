package com.skynoff.smapp2018.ui.model

import com.google.firebase.firestore.FirebaseFirestore
import com.skynoff.smapp2018.background.firebase.models.Assignments
import com.skynoff.smapp2018.background.firebase.models.Lessons
import com.skynoff.smapp2018.ui.presenter.callbacks.LeccionesCallback

/**
 * Created by cesar.smith on 10/20/2017.
 */
class LeccionesModel(var presenter: LeccionesCallback.Presenter) :LeccionesCallback.Model {

    lateinit var db:FirebaseFirestore
    var list: MutableList<Lessons> = mutableListOf()
    var listLessons: MutableList<String> = mutableListOf()



    override fun getLessons() {
        db= FirebaseFirestore.getInstance()
        db.collection("lecciones").get().addOnSuccessListener { snapshot ->
            for (document in snapshot.documents){
                listLessons.add(document.id)

            }
            presenter.setLesson(listLessons)
        }
    }
}