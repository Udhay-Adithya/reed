package com.udhay.reed.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import com.materialkolor.dynamiccolor.ColorSpec
import com.materialkolor.rememberDynamicColorScheme


//private val LightColorScheme = lightColorScheme(
//    primary = Teal,
//    secondary = Aqua,
//    background = White,
//    surface = Color(0xFFDFDDD9),
//    onPrimary = White,
//    onBackground = AlmostBlack,
//    onSurface = AlmostBlack,
//)
//
//private val DarkColorScheme = darkColorScheme(
//    primary = Teal,
//    secondary = Aqua,
//    background = AlmostBlack,
//    surface = Charcoal,
//    onPrimary = AlmostBlack,
//    onBackground = LightGray,
//    onSurface = LightGray,
//)

@Composable
fun ReedTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    // Dynamic color is available on Android 12+
    dynamicColor: Boolean = false,
    isAmoled: Boolean = false,

    content: @Composable () -> Unit
) {
//    val colorScheme = when {
//        dynamicColor -> {
//            val context = LocalContext.current
//            if (darkTheme) dynamicDarkColorScheme(context) else dynamicLightColorScheme(context)
//        }
//
//        darkTheme -> DarkColorScheme
//        else -> LightColorScheme
//    }

    val generatedColorScheme =
        rememberDynamicColorScheme(
            seedColor = seedColor,
            isDark = darkTheme,
            isAmoled = isAmoled,
            specVersion = ColorSpec.SpecVersion.SPEC_2025,
        )


    MaterialTheme(
        colorScheme = generatedColorScheme,
        typography = Typography,
        content = content
    )

}