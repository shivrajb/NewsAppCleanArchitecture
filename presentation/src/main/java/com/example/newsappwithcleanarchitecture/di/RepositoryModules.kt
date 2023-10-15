package com.example.newsappwithcleanarchitecture.di


import com.example.newsappwithcleanarchitecture.repository.NewsRepository
import com.example.newsappwithcleanarchitecture.repository.NewsRepositoryImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModules {
    @Binds
    @Singleton
    abstract fun bindsNewsRepository(impl: NewsRepositoryImpl): NewsRepository
}