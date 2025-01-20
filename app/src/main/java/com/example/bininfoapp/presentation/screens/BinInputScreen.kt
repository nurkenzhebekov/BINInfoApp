package com.example.bininfoapp.presentation.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.bininfoapp.presentation.viewmodel.BinViewModel

@Composable
fun BinInputScreen(
    navigateToHistory: () -> Unit,
    viewModel: BinViewModel = hiltViewModel()
) {
    var binInput by remember { mutableStateOf(TextFieldValue("")) }
    val binInfoState = viewModel.binInfoState.collectAsState()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        TextField(
            value = binInput,
            onValueChange = { binInput = it },
            label = { Text("Введите BIN") },
            modifier = Modifier.fillMaxWidth()
        )

        Button(
            onClick = {viewModel.fetchBinInfo(binInput.text) },
            enabled = binInput.text.isNotBlank()
        ) {
            Text("Получить информацию")
        }

        Spacer(modifier = Modifier.height(16.dp))

        binInfoState.value?.let { binInfo ->
            if (binInfo.isNotEmpty()) {
                Card(
                    modifier = Modifier.fillMaxWidth(),
                    elevation = CardDefaults.cardElevation(8.dp)
                ) {
                    Column(modifier = Modifier.padding(16.dp)) {
                        Text(text = "Схема: ${binInfo.scheme ?: "Неизвестно"}")
                        Text(text = "Тип: ${binInfo.type ?: "Неизвестно"}")
                        Text(text = "Бренд: ${binInfo.brand ?: "Неизвестно"}")
                        Text(text = "Страна: ${binInfo.country ?: "Неизвестно"}")
                        Text(text = "Банк: ${binInfo.bank ?: "Неизвестно"}")
                    }
                }
            } else {
                Text("Введите BIN для отображения информации.")
            }
        }

        Spacer(modifier = Modifier.height(16.dp))

        Button(onClick = navigateToHistory) {
            Text("Перейти к истории")
        }
    }
}