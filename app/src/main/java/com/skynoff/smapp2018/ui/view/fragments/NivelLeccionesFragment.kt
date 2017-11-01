package com.skynoff.smapp2018.ui.view.fragments


import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.CardView
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView

import com.skynoff.smapp2018.R
import com.skynoff.smapp2018.ui.presenter.callbacks.LeccionesCallback
import com.skynoff.smapp2018.ui.presenter.interactors.LeccionesPresenter
import com.skynoff.smapp2018.ui.view.activities.LeccionesActivity


/**
 * A simple [Fragment] subclass.
 */
class NivelLeccionesFragment : Fragment() {

    lateinit var cardviewBasic: CardView
    lateinit var cardviewMidle: CardView
    lateinit var cardviewAdvanced: CardView
    lateinit var cardviewExpert: CardView


    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        val v = inflater!!.inflate(R.layout.fragment_lecciones, container, false)
        cardviewBasic = v.findViewById(R.id.leccion_basico)
        cardviewMidle = v.findViewById(R.id.leccion_medio)
        cardviewAdvanced = v.findViewById(R.id.leccion_avanzado)
        cardviewExpert = v.findViewById(R.id.leccion_experto)
        var imagenBasic: ImageView = cardviewBasic.findViewById(R.id.cv_imagen_nivel)
        var imagenMidle: ImageView = cardviewMidle.findViewById(R.id.cv_imagen_nivel)
        var imagenAdvanced: ImageView = cardviewAdvanced.findViewById(R.id.cv_imagen_nivel)
        var imagenExpert: ImageView = cardviewExpert.findViewById(R.id.cv_imagen_nivel)

        var basicTxt: TextView = cardviewBasic.findViewById(R.id.tv_descripcion_nivel)
        var midleTxt: TextView = cardviewMidle.findViewById(R.id.tv_descripcion_nivel)
        var advancedTxt: TextView = cardviewAdvanced.findViewById(R.id.tv_descripcion_nivel)
        var expertTxt: TextView = cardviewExpert.findViewById(R.id.tv_descripcion_nivel)

        basicTxt.text=getString(R.string.txt_basic_lesson)
        midleTxt.text=getString(R.string.txt_middle_lesson)
        advancedTxt.text=getString(R.string.txt_advanced_lesson)
        expertTxt.text=getString(R.string.txt_expert_lesson)


        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
            imagenBasic.background = resources.getDrawable(R.drawable.for_begginer)
            imagenMidle.background = resources.getDrawable(R.drawable.for_middle)
            imagenAdvanced.background = resources.getDrawable(R.drawable.for_advanced)
            imagenExpert.background = resources.getDrawable(R.drawable.hard_exercise)
        }


        cardviewBasic.setOnClickListener {
            startLecciones("1")
        }
        cardviewMidle.setOnClickListener {
            startLecciones("2")
        }
        cardviewAdvanced.setOnClickListener {
            startLecciones("3")
        }
        cardviewExpert.setOnClickListener {
            startLecciones("4")
        }


        return v

    }

    private fun startLecciones(nivel: String) {
        startActivity(Intent(context, LeccionesActivity::class.java).putExtra("nivel", nivel))
    }


}// Required empty public constructor
