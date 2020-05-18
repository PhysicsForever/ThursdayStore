package com.example.thursdaystore.repository.request_action.properties

import android.util.Log
import io.reactivex.functions.Consumer

class GetPropertiesActionError: Consumer<Throwable> {

    val TAG = this.javaClass.simpleName

    override fun accept(t: Throwable?) {
        Log.d(TAG, "getProperties error", t)
    }

}