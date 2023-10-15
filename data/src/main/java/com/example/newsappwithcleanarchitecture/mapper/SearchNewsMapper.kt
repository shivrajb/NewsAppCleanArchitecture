package com.example.newsappwithcleanarchitecture.mapper

import com.example.newsappwithcleanarchitecture.model.SearchNews
import com.example.newsappwithcleanarchitecture.model.SearchNewsResponse

/**
 * Converts the data from the SearchNewsResponse model to the corresponding domain model.
 *
 * @return The converted SearchNews domain model.
 */
fun SearchNewsResponse.toDomain() = SearchNews(
    news = news.toDomain(),
    page = page,
    status = status
)

/**
 * Converts the data from the SearchNews domain model to the corresponding response model.
 *
 * @return The converted SearchNewsResponse response model.
 */
fun SearchNews.toResponse() = SearchNewsResponse(
    news = news.toResponse(),
    page = page,
    status = status
)