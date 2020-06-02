package com.wednesday.test.repositry

import android.content.Context
import com.wednesday.test.model.SearchedList
import com.wednesday.test.network.Api
import retrofit2.Response

object NetworkRepository : Repository {
    override suspend fun searchSongs(context: Context, query: String): Response<SearchedList> {
        return Api.http.searchTerm(query);

    }

}