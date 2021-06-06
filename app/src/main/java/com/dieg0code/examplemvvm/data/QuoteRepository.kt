package com.dieg0code.examplemvvm.data

import com.dieg0code.examplemvvm.data.model.QuoteModel
import com.dieg0code.examplemvvm.data.model.QuoteProvider
import com.dieg0code.examplemvvm.data.network.QuoteService

class QuoteRepository {

    private val api = QuoteService()

    // obtiene la data y la guarda en memoria
    suspend fun getAllQuotes(): List<QuoteModel> {
        val response = api.getQuote()
        QuoteProvider.quotes = response
        return response
    }
}