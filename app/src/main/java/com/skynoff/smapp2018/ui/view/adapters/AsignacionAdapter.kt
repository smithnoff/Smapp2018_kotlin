package com.skynoff.smapp2018.ui.view.adapters

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.skynoff.smapp2018.R
import com.skynoff.smapp2018.background.firebase.models.Assignments
import kotlinx.android.synthetic.main.item_asignacion.view.*

/**
 * Created by cesar.smith on 10/19/2017.
 */
class AsignacionAdapter(var context: Context, var list: List<Assignments>) : RecyclerView.Adapter<AsignacionAdapter.AsignacionViewHolder>() {


    override fun onBindViewHolder(holder: AsignacionViewHolder?, position: Int) {
        holder?.bindView(list[position])
    }

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): AsignacionViewHolder {
        val vh = LayoutInflater.from(parent?.context).inflate(R.layout.item_asignacion, parent, false)
        return AsignacionViewHolder(vh)
    }

    override fun getItemCount(): Int {
        return list.count()
    }


    class AsignacionViewHolder(itemView: View?) : RecyclerView.ViewHolder(itemView) {


        fun bindView(asignacion: Assignments) {
            itemView.tv_nombre.text = "Tipo: "+asignacion.nombre
            itemView.tv_seccion.text ="seccion: "+ asignacion.seccion
            itemView.tv_tipo.text = "Tipo: "+asignacion.tipo
            itemView.tv_fecha.text ="Fecha: "+ asignacion.fecha
            itemView.tv_puntaje.text = asignacion.puntaje.toString()+"%"
        }

    }


}