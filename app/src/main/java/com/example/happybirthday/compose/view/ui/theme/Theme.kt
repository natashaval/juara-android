package com.example.happybirthday.compose.view.ui.theme

import android.app.Activity
import android.os.Build
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material.*
import androidx.compose.material.Typography
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.dynamicDarkColorScheme
import androidx.compose.material3.dynamicLightColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalView
import androidx.core.view.ViewCompat

private val DarkColorPalette = darkColors(
  primary = Purple200,
  primaryVariant = Purple700,
  secondary = Teal200
)

private val LightColorPalette = lightColors(
  primary = Purple500,
  primaryVariant = Purple700,
  secondary = Teal200

  /* Other default colors to override
    background = Color.White,
    surface = Color.White,
    onPrimary = Color.White,
    onSecondary = Color.Black,
    onBackground = Color.Black,
    onSurface = Color.Black,
    */
)

@Composable
fun HappyBirthdayTheme(
  darkTheme: Boolean = isSystemInDarkTheme(),
  colors: Colors = if (darkTheme) {
    DarkColorPalette
  } else {
    LightColorPalette
  },
  typography: Typography = Typography,
  shapes: Shapes = Shapes,
  content: @Composable () -> Unit,
) {
  MaterialTheme(
    colors = colors,
    typography = typography,
    shapes = shapes,
    content = content
  )
}

private val WoofLightColorPalette = lightColors(
  background = Green100,
  surface = Green50,
  onSurface = Grey900,
  primary = Grey50,
  onPrimary = Grey900,
  secondary = Grey700
)

private val WoofDarkColorPalette = darkColors(
  background = Cyan900,
  surface = Cyan700,
  onSurface = White,
  primary = Grey900,
  onPrimary = White,
  secondary = Grey100
)

@Composable
fun WoofTheme(
  darkTheme: Boolean = isSystemInDarkTheme(),
  content: @Composable () -> Unit) {
  val colors = if (darkTheme) {
    WoofDarkColorPalette
  } else {
    WoofLightColorPalette
  }
  HappyBirthdayTheme(
    darkTheme = darkTheme,
    colors = colors,
    typography = WoofTypography,
    shapes = WoofShapes,
    content = content)
}

val UnscrambleDarkColorPalette = darkColors(
  primary = Indigo200,
  primaryVariant = Indigo800,
  secondary = Light_blue200,
  onSecondary = Black,
  onPrimary = Black,
  secondaryVariant = Light_blue200,
  onBackground = White,
  onSurface = White,
  background = Black,
  surface = Black,
  error = Red400
)

val UnscrambleLightColorPalette = lightColors(
  primary = Indigo500,
  primaryVariant = Indigo800,
  secondary = Light_blue200,
  onSecondary = Black,
  onPrimary = White,
  secondaryVariant = Light_blue700,
  onBackground = Black,
  onSurface = Black,
  background = White,
  surface = White,
  error = Red700
)

@Composable
fun UnscrambleTheme(darkTheme: Boolean = isSystemInDarkTheme(), content: @Composable () -> Unit) {
  val colors = if (darkTheme) {
    UnscrambleDarkColorPalette
  } else {
    UnscrambleLightColorPalette
  }
  HappyBirthdayTheme(
    darkTheme = darkTheme,
    colors = colors,
    typography = Typography,
    shapes = Shapes,
    content = content)
}

// BasicCodelab Material3 Theme
private val BasicCodelabLightColorScheme = lightColorScheme(
  surface = Blue,
  onSurface = Color.White,
  primary = LightBlue,
  onPrimary = Navy
)

private val BasicCodelabDarkColorScheme = darkColorScheme(
  surface = Blue,
  onSurface = Navy,
  primary = Navy,
  onPrimary = Chartreuse
)

@Composable
fun BasicsCodelabTheme(
  darkTheme: Boolean = isSystemInDarkTheme(),
  // Dynamic color is available on Android 12+
  dynamicColor: Boolean = true,
  content: @Composable () -> Unit
) {
  val colorScheme = when {
    dynamicColor && Build.VERSION.SDK_INT >= Build.VERSION_CODES.S -> {
      val context = LocalContext.current
      if (darkTheme) dynamicDarkColorScheme(context) else dynamicLightColorScheme(context)
    }
    darkTheme -> BasicCodelabDarkColorScheme
    else -> BasicCodelabLightColorScheme
  }
  val view = LocalView.current
  if (!view.isInEditMode) {
    SideEffect {
      (view.context as Activity).window.statusBarColor = colorScheme.primary.toArgb()
      ViewCompat.getWindowInsetsController(view)?.isAppearanceLightStatusBars = darkTheme
    }
  }

  androidx.compose.material3.MaterialTheme(
    colorScheme = colorScheme,
    typography = Material3Typography,
    content = content
  )
}

// MySoothe
private val SootheLightColorPalette = lightColors(
  primary = gray900,
  secondary = rust600,
  background = taupe100,
  surface = white850,
  onPrimary = Color.White,
  onSecondary = Color.White,
  onBackground = taupe800,
  onSurface = gray800
)

private val SootheDarkColorPalette = darkColors(
  primary = Color.White,
  secondary = rust300,
  background = gray900,
  surface = white150,
  onPrimary = gray900,
  onSecondary = gray900,
  onBackground = taupe100,
  onSurface = white800
)

@Composable
fun MySootheTheme(darkTheme: Boolean = isSystemInDarkTheme(), content: @Composable() () -> Unit) {
  val colors = if (darkTheme) {
    SootheDarkColorPalette
  } else {
    SootheLightColorPalette
  }
  HappyBirthdayTheme(
    darkTheme = darkTheme,
    colors = colors,
    typography = SootheTypography,
    shapes = SootheShapes,
    content = content
  )
}