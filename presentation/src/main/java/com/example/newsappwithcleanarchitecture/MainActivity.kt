package com.example.newsappwithcleanarchitecture

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import com.example.newsappwithcleanarchitecture.navigation.MainNavHost
import com.example.newsappwithcleanarchitecture.ui.theme.NewsAppWithCleanArchitectureTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            NewsAppWithCleanArchitectureTheme {
                Surface(Modifier.background(MaterialTheme.colorScheme.background)) {
                    MainNavHost()
                }
            }
        }
    }
}