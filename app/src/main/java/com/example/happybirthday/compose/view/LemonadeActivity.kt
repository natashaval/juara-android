package com.example.happybirthday.compose.view

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.happybirthday.R
import com.example.happybirthday.compose.view.ui.theme.HappyBirthdayTheme

class LemonadeActivity : ComponentActivity() {
  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContent {
      HappyBirthdayTheme {
        LemonApp()
      }
    }
  }
}

@Composable
fun LemonApp() {
  var currentStep by remember { mutableStateOf(1) }
  var squeezeCount by remember { mutableStateOf(0) }
  val (lemonText, image, description) = when (currentStep) {
    1 -> Triple(R.string.lemon_tap_select, R.drawable.lemon_tree, R.string.lemon_tree)
    2 -> Triple(R.string.lemon_keep, R.drawable.lemon_squeeze, R.string.lemon)
    3 -> Triple(R.string.lemon_tap_drink, R.drawable.lemon_drink, R.string.lemon_glass)
    else -> Triple(R.string.lemon_tap_empty, R.drawable.lemon_restart, R.string.lemon_empty)
  }

  Surface(modifier = Modifier.fillMaxSize(), color = MaterialTheme.colors.background) {
    when (currentStep) {
      1 -> {
        LemonTextAndImage(
          textId = lemonText,
          drawableId = image,
          contentDescriptionId = description,
          onImageClick = {
            currentStep = 2
            squeezeCount = (2 .. 4).random()
          })
      }
      2 -> {
        LemonTextAndImage(
          textId = lemonText,
          drawableId = image,
          contentDescriptionId = description,
          onImageClick = {
            squeezeCount--
            if (squeezeCount == 0) {
              currentStep = 3
            }
          })
      }
      3 -> {
        LemonTextAndImage(
          textId = lemonText,
          drawableId = image,
          contentDescriptionId = description,
          onImageClick = {
            currentStep = 4
          })
      }
      4 -> {
        LemonTextAndImage(
          textId = lemonText,
          drawableId = image,
          contentDescriptionId = description,
          onImageClick = {
            currentStep = 1
          })
      }
    }
  }
}

@Composable
fun LemonTextAndImage(
  textId: Int,
  drawableId: Int,
  contentDescriptionId: Int,
  onImageClick: () -> Unit,
  modifier: Modifier = Modifier
) {
  Column(
    modifier = modifier.fillMaxSize(),
    verticalArrangement = Arrangement.Center,
    horizontalAlignment = Alignment.CenterHorizontally
  ) {
    Text(text = stringResource(id = textId), fontSize = 18.sp)
    Spacer(modifier = Modifier.height(16.dp))
    Image(
      painter = painterResource(id = drawableId),
      contentDescription = stringResource(id = contentDescriptionId),
      modifier = Modifier
        .wrapContentSize()
        .clickable(
          onClick = onImageClick
        )
        .border(
          BorderStroke(2.dp, Color(105, 205, 216)),
          shape = RoundedCornerShape(4.dp)
        )
    )
  }
}

@Preview(showBackground = true)
@Composable
fun LemonadePreview() {
  HappyBirthdayTheme {
    LemonApp()
  }
}