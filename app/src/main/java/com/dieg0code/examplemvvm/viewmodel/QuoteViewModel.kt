package com.dieg0code.examplemvvm.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.dieg0code.examplemvvm.model.QuoteModel
import com.dieg0code.examplemvvm.model.QuoteProvider

class QuoteViewModel : ViewModel() {

    // encapsulamos el modelo que queremos en un LiveData
    val quoteModel = MutableLiveData<QuoteModel>()

    fun randomQuote() {
        val currentQuote = QuoteProvider.random()
        quoteModel.postValue(currentQuote)
    }
}