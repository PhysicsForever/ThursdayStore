package com.example.thursdaystore.repository.request_action.categories

import android.util.Log
import io.reactivex.functions.Consumer

class GetCategoriesActionError: Consumer<Throwable>{

    val TAG = this.javaClass.simpleName

    override fun accept(t: Throwable?) {
        Log.d(TAG, "getCategories error", t)
    }

}