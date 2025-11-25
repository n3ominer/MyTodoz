package com.example.mytodoz.ui.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Surface
import androidx.compose.material3.Switch
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import com.example.mytodoz.ui.components.TopBar
import com.example.mytodoz.viewModels.SettingsViewModel

@Composable
fun SettingScreen(
    settingsViewModel: SettingsViewModel,
    onBack: () -> Unit
) {

    val isDarkModeOn by settingsViewModel.isDarkMode.collectAsState()

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
            Switch(
                checked = isDarkModeOn,
                onCheckedChange = { settingsViewModel.toggleDarkMode(it) }
            )
        }
    }
}

