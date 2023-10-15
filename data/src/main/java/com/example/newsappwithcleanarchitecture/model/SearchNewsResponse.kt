package com.example.newsappwithcleanarchitecture.model

data class SearchNewsResponse(
    val news: List<NewsResponse>,
    val page: Int,
    val status: String
)