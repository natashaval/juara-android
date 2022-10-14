package com.example.happybirthday.compose.view

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.happybirthday.R
import com.example.happybirthday.compose.view.ui.theme.HappyBirthdayTheme

class QuadrantActivity : ComponentActivity() {
  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContent {
      HappyBirthdayTheme {
        // A surface container using the 'background' color from the theme
        Surface(color = MaterialTheme.colors.background) {
          ComposeBackground()
        }
      }
    }
  }
}

@Composable
fun ComposeBackground() {
  Column(modifier = Modifier.fillMaxWidth()) {
    Row(modifier = Modifier.weight(1f)) {
      ComposeCard(
        title = stringResource(id = R.string.quadrant_text_title),
        body = stringResource(id = R.string.quadrant_text_body),
        backgroundColor = Color.Green,
        modifier = Modifier.weight(1f)
      )
      ComposeCard(
        title = stringResource(id = R.string.quadrant_image_title),
        body = stringResource(id = R.string.quadrant_image_body),
        backgroundColor = Color.Yellow,
        modifier = Modifier.weight(1f)
      )
    }
    Row(modifier = Modifier.weight(1f)) {
      ComposeCard(
        title = stringResource(id = R.string.quadrant_row_title),
        body = stringResource(id = R.string.quadrant_row_body),
        backgroundColor = Color.Cyan,
        modifier = Modifier.weight(1f)
      )
      ComposeCard(
        title = stringResource(id = R.string.quadrant_column_title),
        body = stringResource(id = R.string.quadrant_column_body),
        backgroundColor = Color.LightGray,
        modifier = Modifier.weight(1f)
      )
    }
  }
}

@Composable
fun ComposeCard(
  title: String,
  body: String,
  backgroundColor: Color,
  modifier: Modifier = Modifier
) {
  Column(
    horizontalAlignment = Alignment.CenterHorizontally,
    verticalArrangement = Arrangement.Center,
    modifier = modifier
      .fillMaxSize()
      .background(backgroundColor)
      .padding(16.dp)
  ) {
    Text(
      text = title,
      fontWeight = FontWeight.Bold,
      modifier = Modifier.padding(bottom = 16.dp)
    )
    Text(
      text = body,
      textAlign = TextAlign.Justify
    )
  }
}

@Preview(showBackground = true)
@Composable
fun ComposeBackgroundPreview() {
  HappyBirthdayTheme {
    ComposeBackground()
  }
}