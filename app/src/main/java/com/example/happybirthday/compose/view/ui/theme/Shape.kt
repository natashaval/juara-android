package com.example.happybirthday.compose.view.ui.theme

import androidx.compose.foundation.shape.CutCornerShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Shapes
import androidx.compose.ui.unit.dp

val Shapes = Shapes(
  small = RoundedCornerShape(4.dp),
  medium = RoundedCornerShape(4.dp),
  large = RoundedCornerShape(0.dp)
)

val WoofShapes = Shapes(
  small = RoundedCornerShape(4.dp),
  medium = RoundedCornerShape(16.dp),
  large = RoundedCornerShape(0.dp)
)

val SootheShapes = Shapes(
  small = RoundedCornerShape(4.dp),
  medium = RoundedCornerShape(16.dp)
)

val JetnewsShapes = Shapes(
  small = CutCornerShape(topStart = 8.dp),
  medium = CutCornerShape(topStart = 24.dp),
  large = RoundedCornerShape(8.dp)
)