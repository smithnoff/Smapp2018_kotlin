package com.skynoff.smapp2018.background.firebase.methods

import android.content.ContentValues.TAG
import android.util.Log
import com.google.firebase.iid.FirebaseInstanceId
import com.google.firebase.iid.FirebaseInstanceIdService

/**
 * Created by cesar.smith on 10/30/2017.
 */
class PushNotifications: FirebaseInstanceIdService() {


    override fun onTokenRefresh() {
        var token:String= FirebaseInstanceId.getInstance().token!!
        Log.e(TAG, "Refreshed token: " + token)
    }
}