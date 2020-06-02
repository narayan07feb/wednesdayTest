package com.wednesday.test.repositry

import android.content.Context
import com.wednesday.test.db.AppDatabase
import com.wednesday.test.model.Result
import com.wednesday.test.model.SearchedList
import retrofit2.Response

object DataBaseRepositry : Repository {

    override suspend fun searchSongs(
        applicationContext: Context,
        query: String
    ): Response<SearchedList> {

        val searchItems =
            AppDatabase.getDatabase(applicationContext).getDBService().fetchSearchList(query);
        val response = SearchedList(searchItems.size, searchItems);
        return Response.success(response);

    }

    suspend fun storeSearchList(applicationContext: Context, item: List<Result>?) {
        if (item != null) {
            AppDatabase.getDatabase(applicationContext).getDBService().storeSearchList(item);
        }
    }


}