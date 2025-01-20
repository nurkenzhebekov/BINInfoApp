package com.example.bininfoapp.presentation.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.bininfoapp.data.local.BinEntity
import com.example.bininfoapp.presentation.viewmodel.BinViewModel

@Composable
fun BinHistoryScreen(
    navigateBack: () -> Unit,
    viewModel: BinViewModel = hiltViewModel()
) {
    val history = viewModel.historyState.collectAsState(initial = emptyList())

    Column(modifier = Modifier.fillMaxSize().padding(16.dp)) {
        Button(onClick = navigateBack) {
            Text("Назад")
        }

        Spacer(modifier = Modifier.height(16.dp))

        LazyColumn(verticalArrangement = Arrangement.spacedBy(8.dp)) {
            items(history.value) { binEntity ->
                BinHistoryItem(binEntity = binEntity)
            }
        }
    }
}

@Composable
fun BinHistoryItem(binEntity: BinEntity) {
    Card(
        modifier = Modifier.fillMaxWidth(),
        elevation = CardDefaults.cardElevation(8.dp)
    ) {
        Column(modifier = Modifier.padding(16.dp)) {
            Text(text = "BIN: ${binEntity.bin}")
            Text(text = "Дата: ${binEntity.timestamp}")
        }
    }
}