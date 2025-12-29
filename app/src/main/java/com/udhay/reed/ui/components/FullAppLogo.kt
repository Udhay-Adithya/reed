package com.udhay.reed.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.udhay.reed.R

@Composable
fun FullAppLogo(
) {
    Row(
        horizontalArrangement = Arrangement.Center, verticalAlignment = Alignment.CenterVertically
    ) {
        Box(

            modifier = Modifier
                .padding(10.dp)
                .size(33.dp)
                .background(Color.Black, shape = CircleShape),
            contentAlignment = Alignment.Center

        ) {
            Image(
                painter = painterResource(R.drawable.ic_logo),
                contentDescription = "App icon with app name",
                modifier = Modifier.height(32.dp)
            )
        }

        Text(
            "Reed",
            style = MaterialTheme.typography.titleMedium,
            fontWeight =
                FontWeight.W500,
        )
    }
}

@Preview(showBackground = true)
@Composable
private fun FullAppLogoPreview() {
    FullAppLogo()
}
