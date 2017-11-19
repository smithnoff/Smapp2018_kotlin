package com.skynoff.smapp2018.ui.view.utils

import android.app.DatePickerDialog
import android.content.Context
import android.support.design.widget.TextInputEditText
import java.util.*

/**
 * Created by cesar on 18/11/17.
 */
class PickersDialogs {



    companion object {


        fun setEvalDate(context: Context,inputEditText: TextInputEditText){

            val c = Calendar.getInstance()
            val year = c.get(Calendar.YEAR)
            val month = c.get(Calendar.MONTH)
            val day = c.get(Calendar.DAY_OF_MONTH)


            val dpd = DatePickerDialog(context, DatePickerDialog.OnDateSetListener { view, year, monthOfYear, dayOfMonth ->
                // Display Selected date in textbox
                inputEditText.setText("" + dayOfMonth + " /" + String.format("%02d",(monthOfYear+1)) + "/" + year)
            }, year, month, day)
            dpd.datePicker.minDate=System.currentTimeMillis()-1000
            dpd.show()




        }




    }



}