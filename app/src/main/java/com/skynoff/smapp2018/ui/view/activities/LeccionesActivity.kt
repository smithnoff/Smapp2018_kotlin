package com.skynoff.smapp2018.ui.view.activities

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import com.skynoff.smapp2018.R
import com.skynoff.smapp2018.ui.presenter.callbacks.LeccionesCallback
import com.skynoff.smapp2018.ui.presenter.interactors.LeccionesPresenter

class LeccionesActivity : AppCompatActivity(),LeccionesCallback.View {
    lateinit var recycler: RecyclerView
    lateinit var presenter:LeccionesCallback.Presenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_lecciones)
        presenter= LeccionesPresenter(this)
        recycler=findViewById(R.id.recycler_lecciones)
        recycler.layoutManager= LinearLayoutManager(this)
        presenter.getLessons()


    }
    override fun showResults() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun showErrors() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun setLesson(list: MutableList<String>) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}
