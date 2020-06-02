package com.wednesday.test.model

data class SearchedList(
    val resultCount: Int,
    val results: MutableList<Result>
)