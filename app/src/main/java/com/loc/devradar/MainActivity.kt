package com.loc.devradar

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel
import com.loc.devradar.presentation.feed.FeedScreen
import com.loc.devradar.presentation.feed.FeedViewModel
import com.loc.devradar.ui.theme.DevRadarTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            // Hilt, arka planda tüm gereksinimleri toplayıp FeedViewModel'ı buraya kusursuzca teslim eder
            val viewModel: FeedViewModel = hiltViewModel()

            FeedScreen(viewModel = viewModel)
        }
    }
}