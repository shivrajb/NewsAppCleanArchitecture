package com.example.newsappwithcleanarchitecture.viewmodel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.newsappwithcleanarchitecture.model.LatestNews
import com.example.newsappwithcleanarchitecture.model.News
import com.example.newsappwithcleanarchitecture.model.SearchNews
import com.example.newsappwithcleanarchitecture.model.SearchRequest
import com.example.newsappwithcleanarchitecture.usecases.UcGetLatestNews
import com.example.newsappwithcleanarchitecture.usecases.UcSearchNews
import com.example.newsappwithcleanarchitecture.utils.ApiResult
import com.example.newsappwithcleanarchitecture.utils.SearchRange
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Job
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainPageViewModel @Inject constructor(
    private val latestNewsUc: UcGetLatestNews,
    private val searchNewsUc: UcSearchNews,
    private val ioDispatcher: CoroutineDispatcher
): ViewModel() {
    // Usable data
    var latestNews by mutableStateOf<ApiResult<LatestNews>>(ApiResult.Pending())
        private set
    var searchResult by mutableStateOf<ApiResult<SearchNews>?>(null)
    //      current is the one prepared to be sent to the domain layer, last
    //          is the one that's actually sent. These 2 are here to make
    //          sure duplicate requests aren't sent.
    private var currentQuery = SearchRequest("")
    private var lastQuery = currentQuery

    var filterDateRange by mutableIntStateOf(4) // This is SearchRange.YEAR

    // For UI states
    var searchQuery by mutableStateOf("")
    var filterOpened by mutableStateOf(false)
        private set
    var dateRangeOptionsOpened by mutableStateOf(false)
    var languageOptionsOpened by mutableStateOf(false)
    var countryOptionsOpened by mutableStateOf(false)

    // Others
    private var searchJob: Job? = null

    init { getLatestNews() }

    fun onQueryChange(query: String) {
        searchQuery = query
        searchNews()
        currentQuery = currentQuery.copy(keywords = query)
    }

    fun searchNews(immediate: Boolean = false) {
        searchJob?.cancel()
        searchJob = viewModelScope.launch(ioDispatcher) {
            if (!immediate) delay(1500)
            if (currentQuery != lastQuery) {
                lastQuery = currentQuery
                searchResult = ApiResult.Pending()
                with(searchNewsUc(currentQuery)) { searchResult = this }
            }
        }
    }

    fun toggleFilter(open: Boolean) { filterOpened = open }

    fun getLatestNews() {
        viewModelScope.launch(ioDispatcher) {
            with(latestNewsUc("en")) {
                latestNews = this
            }
        }
    }
}