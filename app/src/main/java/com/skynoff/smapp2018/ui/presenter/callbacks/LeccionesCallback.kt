package com.skynoff.smapp2018.ui.presenter.callbacks

import com.skynoff.smapp2018.background.firebase.models.Lessons

/**
 * Created by cesar.smith on 10/20/2017.
 */
interface LeccionesCallback {

    interface View{
        fun showResults()
        fun showErrors()
        fun setLesson(list:MutableList<Lessons>)


    }
    interface Presenter{
        fun showResults()
        fun showErrors()
        fun setLesson( list:MutableList<Lessons>)
        fun getLessons(nivel:Int)
    }
    interface Model{
        fun getLessons(nivel:Int)

    }




}