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
import com.example.mytodoz.ui.components.TopBar
import com.example.mytodoz.viewModels.SettingsViewModel

@Composable
fun SettingScreen(
    settingVm: SettingsViewModel,
    onBack: () -> Unit
) {

    val darkMode by settingVm.isDarkMode.collectAsState()

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

            Switch(
                checked = darkMode,
                onCheckedChange = { settingVm.toggleDarkMode(it) }
            )
        }
    }
}
