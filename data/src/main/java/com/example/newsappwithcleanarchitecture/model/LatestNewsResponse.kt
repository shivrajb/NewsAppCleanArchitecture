package com.example.newsappwithcleanarchitecture.model

data class LatestNewsResponse(
    val news: List<NewsResponse>,
    val status: String
)