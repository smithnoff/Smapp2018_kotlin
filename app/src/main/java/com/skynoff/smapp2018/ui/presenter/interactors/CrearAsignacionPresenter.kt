package com.skynoff.smapp2018.ui.presenter.interactors

import com.skynoff.smapp2018.ui.model.CrearAsignacionModel
import com.skynoff.smapp2018.ui.presenter.callbacks.CrearAsignacionCallback
import com.skynoff.smapp2018.ui.view.activities.CrearAsignacionActivity

/**
 * Created by cesar.smith on 11/4/2017.
 */
class CrearAsignacionPresenter : CrearAsignacionCallback.Presenter {

    var model: CrearAsignacionCallback.Model
    var view: CrearAsignacionCallback.View

    constructor(view: CrearAsignacionCallback.View) {
        this.view = view
        model = CrearAsignacionModel(this)
    }


    override fun showResults() {
        view.showResults()
    }

    override fun showErrors() {
        view.showErrors()
    }

    override fun createAsign(asignacion: HashMap<String, Any>) {
        model.setCreateAsign(asignacion)
    }
}