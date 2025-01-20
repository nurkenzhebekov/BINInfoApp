package com.example.bininfoapp

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.bininfoapp.presentation.screens.BinHistoryScreen
import com.example.bininfoapp.presentation.screens.BinInputScreen

@Composable
fun NavGraph(navController: NavHostController) {
    NavHost(navController = navController, startDestination = "input") {
        composable("input") {
            BinInputScreen(
                navigateToHistory = { navController.navigate("history")}
            )
        }
        composable("history") {
            BinHistoryScreen(
                navigateBack = { navController.popBackStack()}
            )
        }
    }
}