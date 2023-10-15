package com.example.newsappwithcleanarchitecture.usecases

import com.example.newsappwithcleanarchitecture.repository.NewsRepository
import javax.inject.Inject

class UcGetLatestNews @Inject constructor(
    private val repository: NewsRepository
) {
    suspend operator fun invoke(
        language: String
    ) = repository.getLatestNews(language)
}