package com.example.newsappwithcleanarchitecture.model

data class SearchNews(
    val news: List<News>,
    val page: Int,
    val status: String
)