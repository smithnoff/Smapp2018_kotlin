package com.skynoff.smapp2018.ui.view.fragments


import android.content.Intent
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.CardView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView

import com.skynoff.smapp2018.R
import com.skynoff.smapp2018.ui.view.activities.InteractivosActivity


/**
 * A simple [Fragment] subclass.
 */
class EjerciciosFragment : Fragment() {

    lateinit var interactivos:CardView
    lateinit var propuestos:CardView
    lateinit var resueltos:CardView
    lateinit var descInter:TextView
    lateinit var descProp:TextView
    lateinit var descRes:TextView
    lateinit var tipoInter:TextView
    lateinit var tipoProp:TextView
    lateinit var tipoRes:TextView

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        val v= inflater!!.inflate(R.layout.fragment_ejercicios, container, false)
        interactivos=v.findViewById(R.id.ejercicios_interactivos)
        propuestos=v.findViewById(R.id.ejercicios_propuestos)
        resueltos=v.findViewById(R.id.ejercicios_resueltos)

        val imgInter:ImageView=interactivos.findViewById(R.id.tipo_ejercicio_img)
        val imgProp:ImageView=propuestos.findViewById(R.id.tipo_ejercicio_img)
        val imgRes:ImageView=resueltos.findViewById(R.id.tipo_ejercicio_img)

        imgInter.setImageDrawable(resources.getDrawable(R.drawable.interativos))
        imgProp.setImageDrawable(resources.getDrawable(R.drawable.propuestos))
        imgRes.setImageDrawable(resources.getDrawable(R.drawable.resueltos))

        descInter=interactivos.findViewById(R.id.descripcion_ejercicio_txt)
        descProp=propuestos.findViewById(R.id.descripcion_ejercicio_txt)
        descRes=resueltos.findViewById(R.id.descripcion_ejercicio_txt)

        tipoInter=interactivos.findViewById(R.id.tipo_ejercicio_txt)
        tipoProp=propuestos.findViewById(R.id.tipo_ejercicio_txt)
        tipoRes=resueltos.findViewById(R.id.tipo_ejercicio_txt)


        setText()

        return v
    }

    private fun setText() {
        descInter.text=getString(R.string.desc_interactivos)
        descProp.text=getString(R.string.desc_propuestos)
        descRes.text=getString(R.string.desc_resueltos)

        tipoInter.text=getString(R.string.tipo_interactivo)
        tipoProp.text=getString(R.string.tipo_propuestos)
        tipoRes.text=getString(R.string.tipo_resueltos)

        interactivos.setOnClickListener{
            startActivity(Intent(context,InteractivosActivity::class.java))
        }




    }

}// Required empty public constructor
