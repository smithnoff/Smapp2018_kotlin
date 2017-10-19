package com.skynoff.smapp2018.ui.view.utils

import android.support.design.widget.TextInputEditText
import android.text.InputType
import com.skynoff.smapp2018.R
import kotlinx.android.synthetic.main.activity_register.view.*

/**
 * Created by cesar.smith on 10/18/2017.
 */
class TextValidator {

companion object {
    fun  validateEmpty(inputETArray: List<TextInputEditText>): Boolean {
       var isValid=false
        inputETArray.forEach {

            if (it.text.isEmpty()){
                it.error = "No puede estar vacio"
                it.requestFocus()
         isValid=true
            }
            if(it.id== R.id.tet_email ){
               isValid= android.util.Patterns.EMAIL_ADDRESS.matcher(it.text.toString()).matches()
                it.error = "Email invalido."

            }
        }


        return isValid
    }

}

    
    
    
    
}