package com.skynoff.smapp2018.ui.presenter.callbacks

import com.skynoff.smapp2018.background.firebase.models.Assignments

/**
 * Created by cesar.smith on 10/20/2017.
 */
interface AsignacionCallback {

    interface View{
        fun showResults()
        fun showErrors()
        fun startasignments(list: List<Assignments>)


    }
    interface Presenter{
        fun getAsignments()
        fun startasignments(list: List<Assignments>)
        fun showResults()
        fun showErrors()

    }
    interface Model{
        fun getAsignments()

    }


}