package com.example.bininfoapp.presentation.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.bininfoapp.presentation.viewmodel.BinViewModel
import androidx.hilt.navigation.compose.hiltViewModel

@Preview(showBackground = true)
@Composable
fun BinLookupScreen(
    viewModel: BinViewModel = hiltViewModel(),
    onNavigateToHistory: () -> Unit
) {
    var binInput by remember { mutableStateOf("") }
    val binInfo by viewModel.binInfo.collectAsState()
    val error by viewModel.error.collectAsState()

    Column(Modifier.padding(16.dp)) {
        OutlinedTextField(
            value = binInput,
            onValueChange = { binInput = it },
            label = { Text("Enter BIN") },
            keyboardOptions = KeyboardOptions.Default.copy(
                keyboardType = KeyboardType.Number
            )
        )
        Spacer(Modifier.height(8.dp))
        Button(onClick = { viewModel.fetchBinInfo(binInput)}) {
            Text("Lookup BIN")
        }
        binInfo?.let {
            Text("Scheme: ${it.scheme}")
            Text("Type: ${it.type}")
            Text("Bank: ${it.bank?.name}")
            Text("Country: ${it.country?.name}")
        }
        error?.let {
            Text(text = it, color = Color.Red)
        }
        Spacer(Modifier.height(8.dp))
        Button(onClick = onNavigateToHistory) {
            Text("History")
        }
    }
}