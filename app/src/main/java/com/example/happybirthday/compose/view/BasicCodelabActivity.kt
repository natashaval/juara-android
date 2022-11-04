package com.example.happybirthday.compose.view

import android.content.res.Configuration.UI_MODE_NIGHT_YES
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.animateContentSize
import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.animation.core.spring
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Card
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ExpandLess
import androidx.compose.material.icons.filled.ExpandMore
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.happybirthday.R
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
  Card(
    backgroundColor = MaterialTheme.colorScheme.primary,
    modifier = Modifier.padding(vertical = 4.dp, horizontal = 8.dp)
  ) {
    CardContent(name = name)
  }
}

@Composable
private fun CardContent(name: String) {
  var expanded by remember { mutableStateOf(false) }
  Row(
    modifier = Modifier
      .padding(12.dp)
      .animateContentSize(
        animationSpec = spring(
          dampingRatio = Spring.DampingRatioMediumBouncy,
          stiffness = Spring.StiffnessLow
        )
      )
  ) {
    Column(
      modifier = Modifier
        .weight(1f)
        .padding(12.dp)
    ) {
      Text(text = "Hello, ")
      Text(
        text = name, style = MaterialTheme.typography.headlineMedium.copy(
          fontWeight = FontWeight.ExtraBold
        )
      )
      if (expanded) {
        Text(
          text = ("Composem ipsum color sit lazy, " +
              "padding theme elit, sed do bouncy. ").repeat(4),
        )
      }
    }
    IconButton(onClick = { expanded = !expanded }) {
      Icon(
        imageVector = if (expanded) Icons.Filled.ExpandLess else Icons.Filled.ExpandMore,
        contentDescription = if (expanded) stringResource(id = R.string.show_less)
        else stringResource(id = R.string.show_more)
      )
    }
  }
}

@Composable
private fun MyApp(
  modifier: Modifier = Modifier,
  names: List<String> = List(1000) { "$it" }
) {
  var shouldShowOnboarding by rememberSaveable { mutableStateOf(true) }

  Surface(modifier, color = MaterialTheme.colorScheme.background) {
    if (shouldShowOnboarding) {
      OnboardingScreen(
        onContinueClicked = { shouldShowOnboarding = false }
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