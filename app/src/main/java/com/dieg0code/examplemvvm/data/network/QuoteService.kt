package com.dieg0code.examplemvvm.data.network

import com.dieg0code.examplemvvm.core.RetrofitHelper
import com.dieg0code.examplemvvm.data.model.QuoteModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class QuoteService {

    private val retrofit = RetrofitHelper.getRetrofit()

    /*
        Corutines:

        ejecuta toda la llamada a la api en un hilo secundario para no saturar el hilo principal
        el cual es la UI.
    */
    suspend fun getQuote(): List<QuoteModel> {
        return withContext(Dispatchers.IO) {
            val response = retrofit.create(QuoteApiClient::class.java).getAllQuotes()
            response.body() ?: emptyList()
        }
    }
}