package com.skynoff.smapp2018.ui.presenter.callbacks

/**
 * Created by cesar.smith on 10/18/2017.
 */
interface RegisterCallback {

    interface View{

        fun showResults();
        fun showError();

    }
    interface Presenter{
        fun registerUser();
        fun showResults();
        fun showError();
    }
    interface Model{
        fun registerUser();

    }


}