package com.skynoff.smapp2018.ui.view.activities

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import com.skynoff.smapp2018.R
import com.skynoff.smapp2018.background.firebase.models.Lessons
import com.skynoff.smapp2018.ui.presenter.callbacks.LeccionesCallback
import com.skynoff.smapp2018.ui.presenter.interactors.LeccionesPresenter
import com.skynoff.smapp2018.ui.view.adapters.LeccionesAdapter

class LeccionesActivity : AppCompatActivity(), LeccionesCallback.View {
    lateinit var recycler: RecyclerView
    lateinit var presenter: LeccionesCallback.Presenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_lecciones)
        presenter = LeccionesPresenter(this)
        recycler = findViewById(R.id.recycler_lecciones)
        recycler.layoutManager = LinearLayoutManager(this)

        presenter.getLessons(intent.getStringExtra("nivel").toInt())


    }

    override fun showResults() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun showErrors() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun setLesson(list: MutableList<Lessons>) {
        recycler.adapter = LeccionesAdapter(this, list)
        recycler.adapter.notifyDataSetChanged()
    }
}
