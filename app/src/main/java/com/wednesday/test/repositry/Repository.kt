package com.wednesday.test.repositry

import android.content.Context
import com.wednesday.test.model.SearchedList
import retrofit2.Response

interface Repository {

    suspend fun searchSongs(applicationContext: Context, query: String): Response<SearchedList>

}