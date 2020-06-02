package com.wednesday.test.viewmodel

import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.wednesday.test.model.SearchedList
import com.wednesday.test.repositry.DataBaseRepositry
import com.wednesday.test.repositry.NetworkRepository
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.launch

class SearchViewModel(application: Application) : AndroidViewModel(application) {

    var searchItems = MutableLiveData<SearchedList>();


    fun search(item: String) {
        viewModelScope.launch(errorHandler) {
            val dbResponse = DataBaseRepositry.searchSongs(getApplication(), item);
            searchItems.postValue(dbResponse.body());
            val networkResponse = NetworkRepository.searchSongs(getApplication(), item);
            searchItems.postValue(networkResponse.body());
            DataBaseRepositry.storeSearchList(getApplication(), networkResponse.body()?.results);
        }
    }

    private val errorHandler = CoroutineExceptionHandler { _, exception ->
        Log.d("error",exception.toString());

    }


}