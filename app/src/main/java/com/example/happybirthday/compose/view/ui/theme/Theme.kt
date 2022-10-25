package com.example.happybirthday.compose.view.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

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
  content: @Composable () -> Unit
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