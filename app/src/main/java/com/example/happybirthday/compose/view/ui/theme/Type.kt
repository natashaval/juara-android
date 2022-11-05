package com.example.happybirthday.compose.view.ui.theme

import androidx.compose.material.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.example.happybirthday.R

// Set of Material typography styles to start with
val Typography = Typography(
  body1 = TextStyle(
    fontFamily = FontFamily.Default,
    fontWeight = FontWeight.Normal,
    fontSize = 16.sp
  )
)

val Material3Typography = androidx.compose.material3.Typography(

)

val AbrilFatface = FontFamily(
  Font(R.font.abril_fatface_regular)
)

val Montserrat = FontFamily(
  Font(R.font.montserrat_regular),
  Font(R.font.montserrat_bold, FontWeight.Bold)
)

val WoofTypography = Typography(
  h1 = TextStyle(
    fontFamily = AbrilFatface,
    fontWeight = FontWeight.Normal,
    fontSize = 30.sp
  ),
  h2 = TextStyle(
    fontFamily = Montserrat,
    fontWeight = FontWeight.Bold,
    fontSize = 20.sp
  ),
  h3 = TextStyle(
    fontFamily = Montserrat,
    fontWeight = FontWeight.Bold,
    fontSize = 14.sp
  ),
  body1 = TextStyle(
    fontFamily = Montserrat,
    fontWeight = FontWeight.Normal,
    fontSize = 14.sp
  )
)

// MySoothe
private val fontFamilyKulim = FontFamily(
  listOf(
    Font(
      resId = R.font.kulim_park_regular
    ),
    Font(
      resId = R.font.kulim_park_light,
      weight = FontWeight.Light
    )
  )
)

private val fontFamilyLato = FontFamily(
  listOf(
    Font(
      resId = R.font.lato_regular
    ),
    Font(
      resId = R.font.lato_bold,
      weight = FontWeight.Bold
    )
  )
)

val SootheTypography = Typography(
  defaultFontFamily = fontFamilyLato,
  h1 = TextStyle(
    fontFamily = fontFamilyKulim,
    fontWeight = FontWeight.Light,
    fontSize = 28.sp,
    letterSpacing = (1.15).sp
  ),
  h2 = TextStyle(
    fontFamily = fontFamilyKulim,
    fontSize = 15.sp,
    letterSpacing = (1.15).sp
  ),
  h3 = TextStyle(
    fontWeight = FontWeight.Bold,
    fontSize = 14.sp,
    letterSpacing = 0.sp
  ),
  body1 = TextStyle(
    fontSize = 14.sp,
    letterSpacing = 0.sp
  ),
  button = TextStyle(
    fontWeight = FontWeight.Bold,
    fontSize = 14.sp,
    letterSpacing = (1.15).sp
  ),
  caption = TextStyle(
    fontFamily = fontFamilyKulim,
    fontSize = 12.sp,
    letterSpacing = (1.15).sp
  ),
)