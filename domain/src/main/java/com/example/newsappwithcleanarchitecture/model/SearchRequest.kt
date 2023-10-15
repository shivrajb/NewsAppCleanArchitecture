package com.example.newsappwithcleanarchitecture.model

import com.example.newsappwithcleanarchitecture.utils.SearchRange

data class SearchRequest(
    val keywords: String,
    val dateRange: SearchRange = SearchRange.YEAR,
    val category: String? = null,
    val country: String? = null,
    val language: String? = null
)
