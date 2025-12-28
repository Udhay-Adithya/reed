package com.udhay.reed

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import com.udhay.reed.ui.theme.ReedTheme
import org.koin.compose.viewmodel.koinViewModel

@OptIn(ExperimentalMaterial3Api::class)
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ReedTheme {
                Scaffold(modifier = Modifier.fillMaxSize(),
                    topBar = {
                        TopAppBar(
                            title = { Text("Reed") }
                        )
                    }) { innerPadding ->

                    ShowServerStatus(
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

@Composable
fun ShowServerStatus(viewModel: MainViewModel = koinViewModel(), modifier: Modifier) {
    val state = viewModel.status.collectAsState()
    Column {
        Text(
            text = "${state.value}",
            modifier = modifier
        )
    }
}

//@Preview(showBackground = true)
//@Composable
//fun ShowServerStatusPreview() {
//    ReedTheme {
//        ShowServerStatus()
//    }
//}
