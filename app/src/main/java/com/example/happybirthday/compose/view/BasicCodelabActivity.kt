package com.example.happybirthday.compose.view

import android.content.res.Configuration.UI_MODE_NIGHT_YES
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.animation.core.spring
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.happybirthday.compose.view.ui.theme.BasicsCodelabTheme
import com.example.happybirthday.compose.view.ui.theme.HappyBirthdayTheme

class BasicCodelabActivity : ComponentActivity() {
  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContent {
      BasicsCodelabTheme {
        MyApp(modifier = Modifier.fillMaxSize())
      }
    }
  }
}

@Composable
fun Greeting(name: String) {
  var expanded by remember { mutableStateOf(false) }

  val extraPadding by animateDpAsState(
    if (expanded) 48.dp else 0.dp,
    animationSpec = spring(
      dampingRatio = Spring.DampingRatioMediumBouncy,
      stiffness = Spring.StiffnessLow
    )
  )
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
        Text(text = name, style = MaterialTheme.typography.headlineMedium.copy(
          fontWeight = FontWeight.ExtraBold
        ))
      }
      ElevatedButton(onClick = { expanded = !expanded }) {
        Text(text = if (expanded) "Show less" else "Show more")
      }
    }
  }
}

@Composable
private fun MyApp(
  modifier: Modifier = Modifier,
  names: List<String> = List(1000) { "$it" }
) {
  var shouldShowOnboarding by rememberSaveable { mutableStateOf(true) }

  Surface(modifier) {
    if (shouldShowOnboarding) {
      OnboardingScreen(
        onContinueClicked = { shouldShowOnboarding = false}
      )
    } else {
      Greetings(Modifier, names)
    }
  }
}

@Composable
private fun Greetings(
  modifier: Modifier = Modifier,
  names: List<String> = listOf("World", "Compose")
) {
  LazyColumn(modifier = modifier.padding(vertical = 4.dp)) {
    items(items = names) { name ->
      Greeting(name = name)
    }
  }
}

@Preview(showBackground = true, widthDp = 320)
@Composable
fun BasicCodelabPreview() {
  BasicsCodelabTheme {
    MyApp(Modifier.fillMaxSize())
  }
}

@Preview(showBackground = true, widthDp = 320)
@Composable
private fun GreetingsPreview() {
  BasicsCodelabTheme {
    Greetings()
  }
}

@Preview(
  showBackground = true,
  widthDp = 320,
  uiMode = UI_MODE_NIGHT_YES,
  name = "Dark"
)
@Composable
private fun GreetingsDarkPreview() {
  BasicsCodelabTheme {
    Greetings()
  }
}