package com.example.happybirthday.compose.view

import Message
import android.content.res.Configuration
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.animateContentSize
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.happybirthday.R
import com.example.happybirthday.compose.view.ui.theme.HappyBirthdayTheme

class BasicsActivity : ComponentActivity() {
  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContent {
      HappyBirthdayTheme {
        Surface(modifier = Modifier.fillMaxSize()) {
          MessageCard(Message("Android", "Jetpack Compose"))
        }
      }
    }
  }
}

@Composable
fun MessageCard(msg: Message) {
  // Add padding around our message
  Row(modifier = Modifier.padding(all = 8.dp)) {
    Image(
      painter = painterResource(R.drawable.profile_picture),
      contentDescription = "Contact profile picture",
      modifier = Modifier
        // Set image size to 40 dp
        .size(40.dp)
        // Clip image to be shaped as a circle
        .clip(CircleShape)
        .border(1.5.dp, MaterialTheme.colors.primary, CircleShape)
    )
    // Add a horizontal space between the image and the column
    Spacer(modifier = Modifier.width(8.dp))

    // We keep track if the message is expanded or not in this
    // variable
    var isExpanded by remember { mutableStateOf(false) }
    // surfaceColor will be updated gradually from one color to the other
    val surfaceColor by animateColorAsState(
      if (isExpanded) MaterialTheme.colors.primary else MaterialTheme.colors.surface,
    )

    // We toggle the isExpanded variable when we click on this Column
    Column(modifier = Modifier.clickable { isExpanded = !isExpanded }) {
      Text(
        text = msg.author,
        color = MaterialTheme.colors.secondary,
        style = MaterialTheme.typography.subtitle1
      )
      // Add a vertical space between the author and message texts
      Spacer(modifier = Modifier.height(4.dp))
      Surface(
        shape = MaterialTheme.shapes.medium,
        elevation = 1.dp,
        color = surfaceColor,
        modifier = Modifier.animateContentSize().padding(1.dp)
      ) {
        Text(
          text = msg.body,
          modifier = Modifier.padding(all = 4.dp),
          style = MaterialTheme.typography.body2,
          // If the message is expanded, we display all its content
          // otherwise we only display the first line
          maxLines = if (isExpanded) Int.MAX_VALUE else 1,
        )
      }
    }
  }
}

@Composable
fun Conversation(messages: List<Message>) {
  LazyColumn {
    messages.map {
      item { MessageCard(msg = it) }
    }
  }
}

@Preview(name = "Light Mode")
@Preview(
  uiMode = Configuration.UI_MODE_NIGHT_YES,
  showBackground = true,
  name = "Dark Mode"
)
@Composable
fun PreviewMessageCard() {
  HappyBirthdayTheme {
    Surface {
      MessageCard(
        msg = Message("Lexi", "Hey, take a look at Jetpack Compose, it's great!")
      )
    }
  }
}

@Preview
@Composable
fun PreviewConversation() {
  HappyBirthdayTheme {
    Conversation(messages = SampleData.conversationSample)
  }
}