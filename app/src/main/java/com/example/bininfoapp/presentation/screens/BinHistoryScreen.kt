package com.example.bininfoapp.presentation.screens

import android.content.Intent
import android.net.Uri
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.bininfoapp.presentation.viewmodel.BinHistoryViewModel

@Composable
fun BinHistoryScreen(viewModel: BinHistoryViewModel = hiltViewModel()) {
    val history by viewModel.history.collectAsState()
    val context = LocalContext.current

    LazyColumn(Modifier.padding(16.dp)) {
        items(history) { item ->
            Card(
                modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 4.dp),
                elevation = CardDefaults.cardElevation(4.dp)
            ) {
                Column(Modifier.padding(16.dp)) {
                    Text(text = "BIN: ${item.bin}", style = MaterialTheme.typography.titleSmall)
                    Text(text = "Scheme: ${item.scheme}")
                    Text(text = "Type: ${item.type}")
                    item.bankName?.let { Text(text = "Bank: $it") }
                    item.countryName?.let { Text(text = "Country: $it") }
                    item.bankUrl?.let {
                        Text(
                            text = "URL: $it",
                            color = MaterialTheme.colorScheme.primary,
                            modifier = Modifier.clickable {
                                val intent = Intent(Intent.ACTION_VIEW, Uri.parse(it))
                                context.startActivity(intent)
                            }
                        )
                    }
                }
            }
        }
    }
}