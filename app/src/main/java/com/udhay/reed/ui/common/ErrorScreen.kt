package com.udhay.reed.ui.common

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3ExpressiveApi
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview

@OptIn(ExperimentalMaterial3ExpressiveApi::class)
@Composable
fun ErrorScreen(
    errorMessage: String,
    primaryButton: String,
    secondaryButton: String? = null,
    onPrimaryButtonClicked: () -> Unit,
    onSecondaryButtonClicked: (() -> Unit)?
){
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(errorMessage)
        Button(
            onClick = onPrimaryButtonClicked
        ){
            Text(primaryButton)
        }
        secondaryButton?.let {
            Button(
                onClick = { onSecondaryButtonClicked?.invoke() }
            ){
                Text(it)
            }
        }
    }
}

@Preview
@Composable
fun ErrorScreenPreview(){
    ErrorScreen(
        errorMessage = "Failed to fetch data. Please check your network connection.",
        primaryButton = "Retry",
        onPrimaryButtonClicked = {},
    ) { }
}