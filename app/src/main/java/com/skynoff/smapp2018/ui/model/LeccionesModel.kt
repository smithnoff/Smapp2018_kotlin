package com.skynoff.smapp2018.ui.model

import android.util.Log
import com.google.firebase.firestore.FirebaseFirestore
import com.skynoff.smapp2018.background.firebase.models.Lessons
import com.skynoff.smapp2018.ui.presenter.callbacks.LeccionesCallback

/**
 * Created by cesar.smith on 10/20/2017.
 */
class LeccionesModel(var presenter: LeccionesCallback.Presenter) : LeccionesCallback.Model {

    lateinit var db: FirebaseFirestore
    var list: MutableList<Lessons> = mutableListOf()
    var listLessons: MutableList<String> = mutableListOf()


    override fun getLessons(nivel: Int) {
        db = FirebaseFirestore.getInstance()
        var nivelLec: String = ""
        var divLec: String = ""
        if (nivel == 1) {
            nivelLec = "facil"
            divLec="lf1"

        }else {
            if (nivel == 2) {
                nivelLec = "medio"
                divLec="lm1"
            } else {
                if (nivel == 3) {
                    nivelLec = "dificil"
                    divLec="ld1"

                } else if (nivel == 4) {
                    nivelLec = "avanzado"
                    divLec="la1"

                }
            }
        }
        Log.e("el valor era:", "" + nivel)
        Log.e("el valor en fire:", nivelLec)

        db.collection("lecciones").document(nivelLec).collection(divLec).orderBy("orden") .get() .addOnCompleteListener { snapshot ->
            Log.e("el valor en fire:","entro")
            Log.e("el valor en fire:",""+snapshot.result.size())

            for (documents in snapshot.result) {
                Log.e("ID mil", documents.id)
                list.add(Lessons(documents.id,documents["nombre"] as String, documents["descripcion"] as String))
            }
            presenter.setLesson(list)
        }
    }
}