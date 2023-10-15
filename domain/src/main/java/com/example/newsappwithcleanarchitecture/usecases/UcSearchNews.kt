package com.example.newsappwithcleanarchitecture.usecases

import com.example.newsappwithcleanarchitecture.model.SearchNews
import com.example.newsappwithcleanarchitecture.model.SearchRequest
import com.example.newsappwithcleanarchitecture.repository.NewsRepository
import com.example.newsappwithcleanarchitecture.utils.ApiResult
import com.example.newsappwithcleanarchitecture.utils.toDatePair
import javax.inject.Inject

class UcSearchNews @Inject constructor(
    private val repository: NewsRepository
) {
    suspend operator fun invoke(query: SearchRequest): ApiResult<SearchNews> {
        val dateRange = query.dateRange.toDatePair()

        return repository.searchNews(
            query.keywords,
            dateRange.first,
            dateRange.second,
            query.category,
            query.country,
            query.language
        )
    }
}