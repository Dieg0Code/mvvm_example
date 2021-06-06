    package com.dieg0code.examplemvvm.ui.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.dieg0code.examplemvvm.data.model.QuoteModel
import com.dieg0code.examplemvvm.data.model.QuoteProvider
import com.dieg0code.examplemvvm.domain.GetQuotesUseCase
import com.dieg0code.examplemvvm.domain.GetRandomQuoteUseCase
import kotlinx.coroutines.launch

class QuoteViewModel : ViewModel() {

    // encapsulamos el modelo que queremos en un LiveData
    val quoteModel = MutableLiveData<QuoteModel>()
    val isLoading = MutableLiveData<Boolean>() // muestra u oculta el progress bar

    var getQuoteUseCase = GetQuotesUseCase()
    var getRandomQuoteUseCase = GetRandomQuoteUseCase()

    fun onCreate() {
        // crea una corrutina que se controla automaticamente
        viewModelScope.launch {
            isLoading.postValue(true)
            val result = getQuoteUseCase()

            if (!result.isNullOrEmpty()) {
                quoteModel.postValue(result[0])
                isLoading.postValue(false)
            }
        }
    }

    fun randomQuote() {
        isLoading.postValue(true)
        val quote = getRandomQuoteUseCase()
        if(quote != null) {
            quoteModel.postValue(quote)
        }
        isLoading.postValue(false)
    }


}