package com.loc.devradar.presentation.feed

// presentation/feed/FeedViewModel.kt

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.loc.devradar.data.local.entity.ArticleEntity
import com.loc.devradar.data.repository.ArticleRepositoryImpl
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch
import javax.inject.Inject

// Ekranın bulunabileceği 3 temel durumu tanımlıyoruz
sealed class FeedUiState {
    object Loading : FeedUiState()
    data class Success(val articles: List<ArticleEntity>) : FeedUiState()
    data class Error(val message: String) : FeedUiState()
}

@HiltViewModel
class FeedViewModel @Inject constructor(
    private val repository: ArticleRepositoryImpl
) : ViewModel(){

    // Repository'deki Flow'u, Compose'un anlayacağı StateFlow'a çeviriyoruz.
    // Başlangıç durumu (Loading) olarak belirlenir.
    val uiState: StateFlow<FeedUiState> = repository.articles
        .map { articles ->
            if (articles.isEmpty()) FeedUiState.Loading
            else FeedUiState.Success(articles)
        }
        .stateIn(
            scope = viewModelScope,
            started = SharingStarted.WhileSubscribed(5000),
            initialValue = FeedUiState.Loading
        )

    init {
        // ViewModel ilk oluştuğunda hemen arka planda API'ye gidip güncel veriyi istiyoruz
        fetchLatestData()
    }

    private fun fetchLatestData() {
        viewModelScope.launch {
            repository.syncArticles()
        }
    }
}