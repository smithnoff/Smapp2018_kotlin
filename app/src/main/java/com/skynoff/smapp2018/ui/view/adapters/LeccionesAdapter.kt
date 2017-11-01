package com.skynoff.smapp2018.ui.view.adapters

import android.content.Context
import android.content.Intent
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.skynoff.smapp2018.R
import com.skynoff.smapp2018.background.firebase.models.Lessons
import com.skynoff.smapp2018.ui.view.activities.ContenidosActivity
import kotlinx.android.synthetic.main.item_lecciones_cv.view.*

/**
 * Created by cesar.smith on 10/22/2017.
 */
class LeccionesAdapter(val context: Context, val listLesson: MutableList<Lessons>) : RecyclerView.Adapter<LeccionesAdapter.LeccionesViewHolder>() {

    override fun getItemCount(): Int {
        return listLesson.size
    }

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): LeccionesViewHolder {
        val vh = LayoutInflater.from(parent?.context).inflate(R.layout.item_lecciones_cv, parent, false)
        return LeccionesViewHolder(vh)
    }

    override fun onBindViewHolder(holder: LeccionesViewHolder?, position: Int) {
        holder?.bindViews(listLesson[position])

    }


    class LeccionesViewHolder(itemView: View?) : RecyclerView.ViewHolder(itemView) {
        fun bindViews(lesson: Lessons) {
            itemView.tv_lec_title.text = lesson.nombre
            itemView.tv_lec_content.text = lesson.descripcion
            itemView.setOnClickListener {
                itemView.context.startActivity(Intent(itemView.context,ContenidosActivity::class.java))
            }
        }
    }
}