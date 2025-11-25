package com.example.mytodoz.ui.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import com.example.mytodoz.ui.components.TopBar

@Composable
fun SettingScreen(
    // Add setting viewmodel + injection in  NavGraph
    onBack: () -> Unit
) {
    Surface(
        modifier = Modifier.fillMaxSize(),
        color = Color.Gray
    ) {
        Column(
            modifier = Modifier.fillMaxSize(),
        ) {
            TopBar(
                title = "Settings",
                showBackButton = true,
                onBackClick = onBack
            ) { }

            // Add switch + handle state of data
        }
    }
}


@Preview
@Composable
fun SettingScreenPreview() {
    SettingScreen{}
}