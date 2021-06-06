package com.dieg0code.examplemvvm.data.network

import com.dieg0code.examplemvvm.data.model.QuoteModel
import retrofit2.Response
import retrofit2.http.GET

interface QuoteApiClient {
    @GET("/.json")
    // corutines
    suspend fun getAllQuotes(): Response<List<QuoteModel>>
}