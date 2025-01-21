package com.example.bininfoapp.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.bininfoapp.presentation.screens.BinHistoryScreen
import com.example.bininfoapp.presentation.screens.BinLookupScreen

@Composable
fun AppNavigation() {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = "lookup") {
        composable("lookup") { BinLookupScreen(onNavigateToHistory = { navController.navigate("history") }) }
        composable("history") { BinHistoryScreen() }
    }
}