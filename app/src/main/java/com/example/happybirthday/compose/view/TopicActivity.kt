package com.example.happybirthday.compose.view

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.happybirthday.compose.model.Topic
import com.example.happybirthday.R
import com.example.happybirthday.compose.data.TopicDataSource
import com.example.happybirthday.compose.view.ui.theme.HappyBirthdayTheme
import com.example.happybirthday.compose.view.ui.theme.Typography

class TopicActivity : ComponentActivity() {
  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContent {
      HappyBirthdayTheme {
        // A surface container using the 'background' color from the theme
        Surface(modifier = Modifier.fillMaxSize(), color = MaterialTheme.colors.background) {
          TopicGrid()
        }
      }
    }
  }
}

@Composable
fun TopicGrid(modifier: Modifier = Modifier) {
  LazyVerticalGrid(
    columns = GridCells.Fixed(2),
    verticalArrangement = Arrangement.spacedBy(8.dp),
    horizontalArrangement = Arrangement.spacedBy(8.dp),
    modifier = modifier.padding(8.dp)
  ) {
    items(TopicDataSource.topics.size) { index ->
      TopicCard(topic = TopicDataSource.topics.get(index))
    }
  }
}

@Composable
fun TopicCard(topic: Topic, modifier: Modifier = Modifier) {
  Card(elevation = 4.dp) {
    Row {
      Box {
        Image(
          painter = painterResource(id = topic.imageResourceId),
          contentDescription = null,
          modifier = modifier
            .size(width = 68.dp, height = 68.dp)
            .aspectRatio(1f),
          contentScale = ContentScale.Crop
        )
      }

      Column {
        Text(
          text = stringResource(id = topic.stringResourceId),
          style = MaterialTheme.typography.body2,
          modifier = Modifier.padding(
            start = 16.dp,
            top = 16.dp,
            end = 16.dp,
            bottom = 8.dp
          )
        )
        Row(verticalAlignment = Alignment.CenterVertically) {
          Icon(
            painter = painterResource(R.drawable.ic_grain),
            contentDescription = null,
            modifier = Modifier
              .padding(start = 16.dp)
              .size(12.dp)
          )
          Text(
            text = topic.courses.toString(),
            style = MaterialTheme.typography.caption,
            modifier = Modifier.padding(start = 8.dp)
          )
        }
      }
    }
  }
}

@Preview(showBackground = true)
@Composable
fun TopicPreview() {
  HappyBirthdayTheme {
    TopicGrid()
  }
}