package com.skynoff.smapp2018.ui.presenter.callbacks

/**
 * Created by cesar.smith on 10/20/2017.
 */
interface LeccionesCallback {

    interface View{
        fun showResults()
        fun showErrors()
        fun setLesson(list:MutableList<String>)


    }
    interface Presenter{
        fun showResults()
        fun showErrors()
        fun setLesson( list:MutableList<String>)
        fun getLessons()
    }
    interface Model{
        fun getLessons()

    }




}