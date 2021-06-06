package com.dieg0code.examplemvvm.data.model

class QuoteProvider {
    // un companion object es como un clase estatica en Java
    // todos pueden acceder a ella
    companion object {
        var quotes: List<QuoteModel> = emptyList()
    }

}