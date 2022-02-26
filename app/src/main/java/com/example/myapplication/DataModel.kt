package com.example.myapplication

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

open class DataModel: ViewModel() {
    val messageToActivity: MutableLiveData<String> by lazy {
        MutableLiveData<String>()
    }

    val messageToFragment1: MutableLiveData<String> by lazy {
        MutableLiveData<String>()
    }

    val messageToFragment2:MutableLiveData<String> by lazy {
        MutableLiveData<String>()
    }
}