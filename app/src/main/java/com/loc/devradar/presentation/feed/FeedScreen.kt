package com.loc.devradar.presentation.feed

// presentation/feed/FeedScreen.kt

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState

@Composable
fun FeedScreen(viewModel: FeedViewModel) {
    // ViewModel'daki StateFlow'u Compose state'ine çevirip dinliyoruz
    val state = viewModel.uiState.collectAsState().value

    when (state) {
        is FeedUiState.Loading -> {
            // Veri yoksa veya ilk kez yükleniyorsa dönen animasyon gösterilir
            CircularProgressIndicator()
        }
        is FeedUiState.Success -> {
            // Room'dan veriler geldiğinde liste çizilir
            LazyColumn {
                items(state.articles) { article ->
                    Text(text = article.title)
                    // Burada ArticleCard bileşeni çağrılıp görsel ve diğer detaylar çizilebilir
                }
            }
        }
        is FeedUiState.Error -> {
            Text(text = "Hata oluştu: ${state.message}")
        }
    }
}