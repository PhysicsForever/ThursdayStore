package com.example.thursdaystore.drawer.feedback

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class FeedbackViewModel: ViewModel() {
    val text: LiveData<String> = MutableLiveData<String>().apply { value = "This is feedback Fragment" }
}