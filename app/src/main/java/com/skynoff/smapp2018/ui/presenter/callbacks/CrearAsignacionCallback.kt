package com.skynoff.smapp2018.ui.presenter.callbacks

/**
 * Created by cesar.smith on 11/4/2017.
 */
interface CrearAsignacionCallback {

    interface View{


        fun showResults()
        fun showErrors()

    }

    interface  Presenter{
        fun showResults()
        fun showErrors()
        fun createAsign(asignacion:HashMap<String,Any>)
    }


    interface Model{
        fun setCreateAsign(asignacion:HashMap<String,Any>)

    }

}