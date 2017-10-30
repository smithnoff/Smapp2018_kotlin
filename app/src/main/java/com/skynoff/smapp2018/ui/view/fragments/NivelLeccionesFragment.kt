package com.skynoff.smapp2018.ui.view.fragments


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

import com.skynoff.smapp2018.R
import com.skynoff.smapp2018.ui.presenter.callbacks.LeccionesCallback
import com.skynoff.smapp2018.ui.presenter.interactors.LeccionesPresenter


/**
 * A simple [Fragment] subclass.
 */
class NivelLeccionesFragment : Fragment(){

    lateinit var cardviewBasic:CardView
    lateinit var cardviewMidle:CardView
    lateinit var cardviewAdvanced:CardView
    lateinit var cardviewExpert:CardView


    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        val v =inflater!!.inflate(R.layout.fragment_lecciones, container, false)
            cardviewBasic=v.findViewById(R.id.leccion_basico)
            cardviewMidle=v.findViewById(R.id.leccion_medio)
            cardviewAdvanced=v.findViewById(R.id.leccion_avanzado)
            cardviewExpert=v.findViewById(R.id.leccion_experto)
       var imagenBasic:ImageView= cardviewBasic.findViewById(R.id.cv_imagen_nivel)
       var imagenMidle:ImageView= cardviewMidle.findViewById(R.id.cv_imagen_nivel)
       var imagenAdvanced:ImageView= cardviewAdvanced.findViewById(R.id.cv_imagen_nivel)
       var imagenExpert:ImageView= cardviewExpert.findViewById(R.id.cv_imagen_nivel)
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
            imagenBasic.background = resources.getDrawable(R.drawable.for_begginer)
            imagenMidle.background = resources.getDrawable(R.drawable.for_middle)
            imagenAdvanced.background = resources.getDrawable(R.drawable.for_advanced)
            imagenExpert.background = resources.getDrawable(R.drawable.hard_exercise)
        }
            return v

    }



}// Required empty public constructor
