package com.skynoff.smapp2018.ui.presenter.interactors

import com.skynoff.smapp2018.background.firebase.models.Assignments
import com.skynoff.smapp2018.ui.model.AsignacionModel
import com.skynoff.smapp2018.ui.presenter.callbacks.AsignacionCallback

/**
 * Created by cesar.smith on 10/20/2017.
 */
class AsignacionPresenter : AsignacionCallback.Presenter {

    var view: AsignacionCallback.View
    var model: AsignacionCallback.Model

    constructor(view: AsignacionCallback.View) {
        this.view = view
        model = AsignacionModel(this)
    }


    override fun getAsignments() {
        model.getAsignments()
    }

    override fun startasignments(list: List<Assignments>) {
        view.startasignments(list)
    }

    override fun showResults() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun showErrors() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}