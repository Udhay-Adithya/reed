package com.udhay.reed.ui.theme

import androidx.compose.material3.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.unit.sp
import com.udhay.reed.R


val fontFamily = FontFamily(
    // Thin
    Font(R.font.spotifymix_thin, weight = FontWeight.Thin),
    Font(R.font.spotifymix_thin_italic, weight = FontWeight.Thin, style = FontStyle.Italic),

    // Light
    Font(R.font.spotifymix_light, weight = FontWeight.Light),
    Font(R.font.spotifymix_light_italic, weight = FontWeight.Light, style = FontStyle.Italic),

    // Regular / Normal
    Font(R.font.spotifymix_regular, weight = FontWeight.Normal),
    Font(R.font.spotifymix_regular_italic, weight = FontWeight.Normal, style = FontStyle.Italic),

    // Medium
    Font(R.font.spotifymix_medium, weight = FontWeight.Medium),
    Font(R.font.spotifymix_medium_italic, weight = FontWeight.Medium, style = FontStyle.Italic),

    // Bold
    Font(R.font.spotifymix_bold, weight = FontWeight.Bold),
    Font(R.font.spotifymix_bold_italic, weight = FontWeight.Bold, style = FontStyle.Italic),

    // ExtraBold (mapped to W800)
    Font(R.font.spotifymix_extrabold, weight = FontWeight.W800),
    Font(R.font.spotifymix_extrabold_italic, weight = FontWeight.W800, style = FontStyle.Italic),

    // Black
    Font(R.font.spotifymix_black, weight = FontWeight.Black),
    Font(R.font.spotifymix_black_italic, weight = FontWeight.Black, style = FontStyle.Italic),

    // Ultra (use W900)
    Font(R.font.spotifymix_ultra, weight = FontWeight.W900),
    Font(R.font.spotifymix_ultra_italic, weight = FontWeight.W900, style = FontStyle.Italic),
)

// Set of Material typography styles to start with — override defaults to use the app fontFamily
val Typography = Typography(
    // Display
    displayLarge = TextStyle(
        fontFamily = fontFamily,
        fontWeight = FontWeight.Light,
        fontSize = 57.sp,
        lineHeight = 64.sp,
        letterSpacing = (-0.25).sp
    ),
    displayMedium = TextStyle(
        fontFamily = fontFamily,
        fontWeight = FontWeight.Light,
        fontSize = 45.sp,
        lineHeight = 52.sp,
        letterSpacing = 0.sp
    ),
    displaySmall = TextStyle(
        fontFamily = fontFamily,
        fontWeight = FontWeight.Normal,
        fontSize = 36.sp,
        lineHeight = 44.sp,
        letterSpacing = 0.sp
    ),

    // Headline
    headlineLarge = TextStyle(
        fontFamily = fontFamily,
        fontWeight = FontWeight.Normal,
        fontSize = 32.sp,
        lineHeight = 40.sp,
        letterSpacing = 0.sp
    ),
    headlineMedium = TextStyle(
        fontFamily = fontFamily,
        fontWeight = FontWeight.Normal,
        fontSize = 28.sp,
        lineHeight = 36.sp,
        letterSpacing = 0.sp
    ),
    headlineSmall = TextStyle(
        fontFamily = fontFamily,
        fontWeight = FontWeight.Normal,
        fontSize = 24.sp,
        lineHeight = 32.sp,
        letterSpacing = 0.sp
    ),

    // Title
    titleLarge = TextStyle(
        fontFamily = fontFamily,
        fontWeight = FontWeight.SemiBold,
        fontSize = 22.sp,
        lineHeight = 28.sp,
        letterSpacing = 0.sp
    ),
    titleMedium = TextStyle(
        fontFamily = fontFamily,
        fontWeight = FontWeight.Medium,
        fontSize = 16.sp,
        lineHeight = 24.sp,
        letterSpacing = 0.15.sp
    ),
    titleSmall = TextStyle(
        fontFamily = fontFamily,
        fontWeight = FontWeight.Medium,
        fontSize = 14.sp,
        lineHeight = 20.sp,
        letterSpacing = 0.1.sp
    ),

    // Body
    bodyLarge = TextStyle(
        fontFamily = fontFamily,
        fontWeight = FontWeight.Normal,
        fontSize = 16.sp,
        lineHeight = 24.sp,
        letterSpacing = 0.5.sp
    ),
    bodyMedium = TextStyle(
        fontFamily = fontFamily,
        fontWeight = FontWeight.Normal,
        fontSize = 14.sp,
        lineHeight = 20.sp,
        letterSpacing = 0.25.sp
    ),
    bodySmall = TextStyle(
        fontFamily = fontFamily,
        fontWeight = FontWeight.Normal,
        fontSize = 12.sp,
        lineHeight = 16.sp,
        letterSpacing = 0.4.sp
    ),

    // Label
    labelLarge = TextStyle(
        fontFamily = fontFamily,
        fontWeight = FontWeight.Medium,
        fontSize = 14.sp,
        lineHeight = 20.sp,
        letterSpacing = 0.1.sp
    ),
    labelMedium = TextStyle(
        fontFamily = fontFamily,
        fontWeight = FontWeight.Medium,
        fontSize = 12.sp,
        lineHeight = 16.sp,
        letterSpacing = 0.5.sp
    ),
    labelSmall = TextStyle(
        fontFamily = fontFamily,
        fontWeight = FontWeight.Medium,
        fontSize = 11.sp,
        lineHeight = 16.sp,
        letterSpacing = 0.5.sp
    )
)