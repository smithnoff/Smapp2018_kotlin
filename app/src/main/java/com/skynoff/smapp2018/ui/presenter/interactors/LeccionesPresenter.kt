package com.skynoff.smapp2018.ui.presenter.interactors

import com.skynoff.smapp2018.ui.model.LeccionesModel
import com.skynoff.smapp2018.ui.presenter.callbacks.LeccionesCallback

/**
 * Created by cesar.smith on 10/20/2017.
 */
class LeccionesPresenter:LeccionesCallback.Presenter {
    var view:LeccionesCallback.View
    var model:LeccionesCallback.Model

    constructor(view: LeccionesCallback.View) {
        this.view = view
        model=LeccionesModel(this@LeccionesPresenter)
    }

    override fun showResults() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun showErrors() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun setLesson(list:MutableList<String>) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun getLessons() {
         model.getLessons()
    }


}