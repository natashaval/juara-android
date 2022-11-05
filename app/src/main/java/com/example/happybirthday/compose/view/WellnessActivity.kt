package com.example.happybirthday.compose.view

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.happybirthday.compose.view.ui.theme.HappyBirthdayTheme

class WellnessActivity : ComponentActivity() {
  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContent {
      HappyBirthdayTheme {
        Surface(modifier = Modifier.fillMaxSize(), color = MaterialTheme.colors.background) {
          WellnessScreen()
        }
      }
    }
  }
}

@Composable
fun WaterCounter(modifier: Modifier = Modifier) {
  Column(modifier = modifier.padding(16.dp)) {
    var count by remember { mutableStateOf(0) }
    if (count > 0) {
      var showTask by remember { mutableStateOf(true) }
      if (showTask) {
        WellnessTaskItem(
          taskName = "Have you taken your 15 minute walk today?",
          onClose = { showTask = false })
      }
      Text(text = "You've had $count glasses.")
    }
    Row(modifier = Modifier.padding(top = 8.dp)) {
      Button(onClick = { count++ }, enabled = count < 10) {
        Text("Add one")
      }
      Button(onClick = { count = 0}, modifier = Modifier.padding(start = 8.dp)) {
        Text("Clear water count")
      }
    }
  }
}

@Composable
fun WellnessTaskItem(
  taskName: String,
  onClose: () -> Unit,
  modifier: Modifier = Modifier
) {
  Row(
    modifier = modifier,
    verticalAlignment = Alignment.CenterVertically
  ) {
    Text(
      modifier = Modifier
        .weight(1f)
        .padding(start = 16.dp),
      text = taskName
    )
    IconButton(onClick = onClose) {
      Icon(
        imageVector = Icons.Filled.Close,
        contentDescription = "Close"
      )
    }
  }
}

@Composable
fun WellnessScreen(modifier: Modifier = Modifier) {
  WaterCounter(modifier = modifier)
}

@Preview(showBackground = true)
@Composable
fun WellnessPreview() {
  HappyBirthdayTheme {
    WellnessScreen()
  }
}