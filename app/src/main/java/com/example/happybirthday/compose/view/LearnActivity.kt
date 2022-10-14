package com.example.happybirthday.compose.view

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.happybirthday.R
import com.example.happybirthday.compose.view.ui.theme.HappyBirthdayTheme

class LearnActivity : ComponentActivity() {
  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContent {
      HappyBirthdayTheme {
        // A surface container using the 'background' color from the theme
        Surface(color = MaterialTheme.colors.background) {
          ComposableArticleApp()
        }
      }
    }
  }
}

@Composable
fun ComposableArticleApp() {
  ArticleCard(
    title = stringResource(id = R.string.learn_title),
    shortDescription = stringResource(id = R.string.learn_body_1),
    longDescription = stringResource(id = R.string.learn_body_2),
    imagePainter = painterResource(id = R.drawable.bg_compose_background)
  )
}

@Composable
fun ArticleCard(
  title: String,
  shortDescription: String,
  longDescription: String,
  imagePainter: Painter,
  modifier: Modifier = Modifier
) {
  Column(modifier) {
    Image(
      painter = imagePainter,
      contentDescription = null,
      modifier = Modifier.fillMaxWidth()
    )
    Text(
      text = title,
      fontSize = 24.sp,
      modifier = Modifier.padding(16.dp)
    )
    Text(
      text = shortDescription,
      modifier = Modifier.padding(start = 16.dp, end = 16.dp),
      textAlign = TextAlign.Justify
    )
    Text(
      text = longDescription,
      modifier = Modifier.padding(16.dp),
      textAlign = TextAlign.Justify
    )
  }
}

@Preview(showBackground = false)
@Composable
fun PreviewLearnCompose() {
  HappyBirthdayTheme {
    ComposableArticleApp()
  }
}