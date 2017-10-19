package com.skynoff.smapp2018.ui.presenter.interactors

import com.skynoff.smapp2018.background.firebase.models.Users
import com.skynoff.smapp2018.ui.model.RegisterModel
import com.skynoff.smapp2018.ui.presenter.callbacks.RegisterCallback

/**
 * Created by cesar.smith on 10/18/2017.
 */
class RegisterPresenter : RegisterCallback.Presenter {
    var view: RegisterCallback.View
    var model: RegisterCallback.Model

    constructor(view: RegisterCallback.View) {
        this.view = view
        model = RegisterModel(this)
    }

    override fun registerUser(user: Users) {
        model.registerUser(user)
    }

    override fun showResults() {
        view.showResults()
    }

    override fun showError() {
        view.showError()
    }


}