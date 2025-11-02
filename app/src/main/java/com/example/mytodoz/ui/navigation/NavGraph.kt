package com.example.mytodoz.ui.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.mytodoz.ui.screens.HomeScreen
import com.example.mytodoz.ui.screens.NoteDetailScreen
import com.example.mytodoz.ui.screens.SettingScreen
import com.example.mytodoz.viewModels.NotesViewModel



@Composable
fun NavGraph(viewModel: NotesViewModel){

    // STATE
    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = Destinations.HOME
    ) {
        // Definir l'affichage de chaque écran
        // 1 écran == 1 composable()
        composable(route = Destinations.HOME) {
            HomeScreen(
                viewModel = viewModel,
                onOpenNote = { noteId ->
                    navController.navigate("${Destinations.DETAIL}/$noteId")
                },
                onOpenSettings = { navController.navigate(Destinations.PROFILE) },
                folderName = "My notes Pro"
            )
        }

        composable(
            route = "${Destinations.DETAIL}/{noteId}",
            arguments = listOf(navArgument("noteId") { type = NavType.IntType})
        ) { backStackEntry ->
            val noteId = backStackEntry.arguments?.getInt("noteId") ?: - 1

            NoteDetailScreen(
                noteId = noteId,
                viewModel = viewModel,
                onBackClick = { navController.popBackStack() },
                folderName = "My notes Pro",
                onSettingClick = {}
            )
        }

        // TODO: FInish settings screen implementation
        composable(route = Destinations.PROFILE) {
            SettingScreen(
                onBack = { navController.popBackStack() }
            )
        }
    }
}