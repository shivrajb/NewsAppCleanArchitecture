package com.example.newsappwithcleanarchitecture.repository

import com.example.newsappwithcleanarchitecture.model.LatestNews
import com.example.newsappwithcleanarchitecture.model.SearchNews
import com.example.newsappwithcleanarchitecture.utils.ApiResult

interface NewsRepository {
    suspend fun getLatestNews(language: String): ApiResult<LatestNews>
    suspend fun searchNews(
        keywords: String,
        start_date: String? = null,
        end_date: String? = null,
        category: String? = null,
        country: String? = null,
        language: String? = null
    ): ApiResult<SearchNews>
}