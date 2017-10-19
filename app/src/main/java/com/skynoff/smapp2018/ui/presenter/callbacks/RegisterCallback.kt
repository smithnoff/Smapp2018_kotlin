package com.skynoff.smapp2018.ui.presenter.callbacks

import com.skynoff.smapp2018.background.firebase.models.Users

/**
 * Created by cesar.smith on 10/18/2017.
 */
interface RegisterCallback {

    interface View{

        fun showResults()
        fun showError()

    }
    interface Presenter{
        fun registerUser(user:Users)
        fun showResults()
        fun showError()
    }
    interface Model{
        fun registerUser(user:Users)

    }


}