package com.se7en.fearngreed

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import com.se7en.fearngreed.ui.theme.FearNGreedTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            FearNGreedTheme {
                Surface(color = MaterialTheme.colors.background) {
                    Text("FearNGreed")
                }
            }
        }
    }
}
