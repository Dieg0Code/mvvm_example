package com.dieg0code.examplemvvm.domain

import com.dieg0code.examplemvvm.data.QuoteRepository
import com.dieg0code.examplemvvm.data.model.QuoteModel

class GetQuotesUseCase {

    private val repository = QuoteRepository()

    // cada vez que se llame a esta clase se ejecutara directamente este bloque (invoke)
    suspend operator fun invoke(): List<QuoteModel>? = repository.getAllQuotes()
}