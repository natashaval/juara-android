package com.example.happybirthday.compose.view

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.happybirthday.compose.view.ui.theme.HappyBirthdayTheme

class BasicCodelabActivity : ComponentActivity() {
  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContent {
      HappyBirthdayTheme {
        MyApp(modifier = Modifier.fillMaxSize())
      }
    }
  }
}

@Composable
fun Greeting(name: String) {
  val expanded = remember { mutableStateOf(false) }

  val extraPadding = if (expanded.value) 48.dp else 0.dp
  Surface(
    color = MaterialTheme.colorScheme.primary,
    modifier = Modifier.padding(vertical = 4.dp, horizontal = 8.dp)
  ) {
    Row(modifier = Modifier.padding(24.dp)) {
      Column(modifier = Modifier
        .weight(1f)
        .padding(bottom = extraPadding)
      ) {
        Text(text = "Hello, ")
        Text(text = name)
      }
      ElevatedButton(onClick = { expanded.value = !expanded.value }) {
        Text(text = if (expanded.value) "Show less" else "Show more")
      }
    }
  }
}

@Composable
private fun MyApp(
  modifier: Modifier = Modifier,
  names: List<String> = listOf("World", "Compose")
) {
  var shouldShowOnboarding by remember { mutableStateOf(true) }

  Surface(modifier) {
    if (shouldShowOnboarding) {
      OnboardingScreen(
        onContinueClicked = { shouldShowOnboarding = false}
      )
    } else {
      Greetings()
    }
  }
}

@Composable
private fun Greetings(
  modifier: Modifier = Modifier,
  names: List<String> = listOf("World", "Compose")
) {
  Column(modifier = modifier.padding(vertical = 4.dp)) {
    for (name in names) {
      Greeting(name = name)
    }
  }
}

@Preview(showBackground = true, widthDp = 320)
@Composable
fun BasicCodelabPreview() {
  HappyBirthdayTheme {
    MyApp(Modifier.fillMaxSize())
  }
}

@Preview(showBackground = true, widthDp = 320)
@Composable
private fun GreetingsPreview() {
  HappyBirthdayTheme {
    Greetings()
  }
}