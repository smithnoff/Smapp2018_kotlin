package com.skynoff.smapp2018.ui.view.fragments


import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.preference.PreferenceManager
import android.support.design.widget.FloatingActionButton
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView

import com.skynoff.smapp2018.R
import com.skynoff.smapp2018.background.firebase.models.Assignments
import com.skynoff.smapp2018.ui.presenter.callbacks.AsignacionCallback
import com.skynoff.smapp2018.ui.presenter.interactors.AsignacionPresenter
import com.skynoff.smapp2018.ui.view.activities.CrearAsignacionActivity
import com.skynoff.smapp2018.ui.view.adapters.AsignacionAdapter
import com.skynoff.smapp2018.ui.view.utils.TextValidator


/**
 * A simple [Fragment] subclass.
 */
class AsignacionFragment : Fragment(), AsignacionCallback.View {


    lateinit var recycler: RecyclerView
    lateinit var presenter: AsignacionCallback.Presenter
    lateinit var fab: FloatingActionButton
    lateinit var shared: SharedPreferences


    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        val v = inflater!!.inflate(R.layout.fragment_asignacion, container, false)

        recycler = v.findViewById(R.id.rv_asignaciones)
        recycler.layoutManager = LinearLayoutManager(context)
        presenter = AsignacionPresenter(this)
        fab = v.findViewById(R.id.fab_add_assign)

        shared = PreferenceManager.getDefaultSharedPreferences(context)
        Log.e("vale shred", "" + shared.getInt("nivel", 0))
        if (shared.getInt("nivel", 0) == 3) {
            fab.visibility = View.VISIBLE

        } else {
            fab.visibility = View.GONE

        }

        if (recycler.childCount == 0)
            presenter.getAsignments()

        fab.setOnClickListener {
            startActivity(Intent(context, CrearAsignacionActivity::class.java))
        }


        return v
    }

    override fun showResults() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun showErrors() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun startasignments(list: List<Assignments>) {
        if (context != null) {
            recycler.adapter = AsignacionAdapter(context, list)
            recycler.adapter.notifyDataSetChanged()
        }
    }

}// Required empty public constructor
