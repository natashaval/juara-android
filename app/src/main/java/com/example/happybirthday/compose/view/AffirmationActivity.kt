package com.example.happybirthday.compose.view

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.happybirthday.R
import com.example.happybirthday.affirmation.data.Datasource
import com.example.happybirthday.affirmation.model.Affirmation
import com.example.happybirthday.compose.view.ui.theme.HappyBirthdayTheme

class AffirmationActivity : ComponentActivity() {
  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContent {
      HappyBirthdayTheme {
        // A surface container using the 'background' color from the theme
        Surface(modifier = Modifier.fillMaxSize(), color = MaterialTheme.colors.background) {
          AffirmationApp()
        }
      }
    }
  }
}

@Preview
@Composable
fun AffirmationApp() {
  HappyBirthdayTheme {
    Scaffold { padding ->
      AffirmationList(
        affirmationList = Datasource().loadAffirmations(),
        modifier = Modifier.padding(padding)
      )
    }
  }
}

@Composable
fun AffirmationCard(affirmation: Affirmation, modifier: Modifier = Modifier) {
  Card(modifier = modifier.padding(8.dp), elevation = 4.dp) {
    Column {
      Image(
        painter = painterResource(id = affirmation.imageResourceId),
        contentDescription = stringResource(id = affirmation.stringResourceId),
        modifier = Modifier
          .fillMaxWidth()
          .height(194.dp),
        contentScale = ContentScale.Crop
      )
      Text(
        text = stringResource(id = affirmation.stringResourceId),
        modifier = Modifier.padding(16.dp),
        style = MaterialTheme.typography.h6
      )
    }
  }
}

@Preview
@Composable
fun AffirmationCardPreview() {
  AffirmationCard(affirmation = Affirmation(R.string.affirmation1, R.drawable.image1))
}

@Composable
private fun AffirmationList(affirmationList: List<Affirmation>, modifier: Modifier = Modifier) {
  LazyColumn {
    items(affirmationList) { affirmation ->
      AffirmationCard(affirmation = affirmation)
    }
  }
}