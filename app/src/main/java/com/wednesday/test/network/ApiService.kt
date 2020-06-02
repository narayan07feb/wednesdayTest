package com.wednesday.test.network

import com.wednesday.test.model.SearchedList
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {
    @GET("/search")
    suspend fun searchTerm(@Query("term") order: String): Response<SearchedList>
}