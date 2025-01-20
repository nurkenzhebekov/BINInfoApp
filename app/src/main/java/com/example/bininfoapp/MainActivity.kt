package com.example.bininfoapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Divider
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.bininfoapp.model.BinRequestHistory
import com.example.bininfoapp.ui.theme.BINInfoAppTheme
import com.example.bininfoapp.viewmodel.BinRequestHistoryViewModel

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {

        }
    }
}

@Composable
fun BinRequestHistoryScreen(viewModel: BinRequestHistoryViewModel) {
    val history by viewModel.history.observeAsState(listOf())

    LazyColumn {
        items(history) { historyItem ->
            BinRequestHistoryItem(historyItem)
        }
    }

    LaunchedEffect(true) {
        viewModel.fetchHistory()
    }
}

@Composable
fun BinRequestHistoryItem(historyItem: BinRequestHistory) {
    Column(modifier = Modifier.padding(16.dp)) {
        Text(text = "BIN: ${historyItem.bin}")
        Text(text = "Country: ${historyItem.country}")
        Text(text = "Card Type: ${historyItem.cardType}")
        Text(text = "Bank: ${historyItem.bankName}")
        Text(text = "URL: ${historyItem.bankUrl}")
        Divider()
    }
}