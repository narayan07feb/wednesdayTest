package com.wednesday.test

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.GridLayoutManager
import com.wednesday.test.adapter.SearchAdapter
import com.wednesday.test.diffutils.SearchDiffUtils
import com.wednesday.test.ext.afterTextChangedDelayed
import com.wednesday.test.model.Result
import com.wednesday.test.viewmodel.SearchViewModel
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private val searchViewModel: SearchViewModel by lazy {
        ViewModelProvider(this).get(SearchViewModel::class.java);
    }
    private var searchItems: ArrayList<Result> = ArrayList<Result>();

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        search_box.afterTextChangedDelayed {
            searchViewModel.search(it);
        }

        val gridLayoutManager = GridLayoutManager(this, 2)
        val searchAdapter = SearchAdapter(this, searchItems);

        recyclerview.apply {
            layoutManager = gridLayoutManager;
            adapter = searchAdapter;
        }

        searchViewModel?.searchItems?.observe(this, Observer {
            if (it != null) {
                val searchDiffUtils = SearchDiffUtils(it.results, searchItems);
                val diffResult = DiffUtil.calculateDiff(searchDiffUtils, true);
                searchItems.clear()
                searchItems.addAll(it.results);
                searchItems
                recyclerview.adapter?.let { it1 -> diffResult.dispatchUpdatesTo(it1) }

            }
        });
    }

}