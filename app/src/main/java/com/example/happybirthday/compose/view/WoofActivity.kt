package com.example.happybirthday.compose.view

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.compose.animation.animateContentSize
import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.spring
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ExpandLess
import androidx.compose.material.icons.filled.ExpandMore
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.happybirthday.R
import com.example.happybirthday.compose.model.Dog
import com.example.happybirthday.compose.model.dogs
import com.example.happybirthday.compose.view.ui.theme.HappyBirthdayTheme
import com.example.happybirthday.compose.view.ui.theme.WoofShapes
import com.example.happybirthday.compose.view.ui.theme.WoofTheme

class WoofActivity : ComponentActivity() {
  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContent {
      WoofTheme {
        // A surface container using the 'background' color from the theme
        Surface(modifier = Modifier.fillMaxSize(), color = MaterialTheme.colors.background) {
          WoofApp()
        }
      }
    }
  }
}

/**
 * Composable that displays an app bar and a list of dogs.
 */
@Composable
fun WoofApp() {
  Scaffold(
    topBar = {
      WoofTopAppBar()
    }
  ) { padding ->
    LazyColumn(
      modifier = Modifier
        .background(MaterialTheme.colors.background)
        .padding(padding)
    ) {
      items(dogs) {
        DogItem(dog = it)
      }
    }
  }
}

@Composable
fun WoofTopAppBar(modifier: Modifier = Modifier) {
  Row(
    modifier = modifier
      .fillMaxWidth()
      .background(color = MaterialTheme.colors.primary),
    verticalAlignment = Alignment.CenterVertically
  ) {
    Image(
      modifier = Modifier
        .size(64.dp)
        .padding(8.dp),
      painter = painterResource(id = R.drawable.ic_woof_logo),
      contentDescription = null
    )
    Text(
      text = stringResource(id = R.string.woof_app_name),
      style = MaterialTheme.typography.h1
    )
  }
}

/**
 * Composable that displays a list item containing a dog icon and their information.
 *
 * @param dog contains the data that populates the list item
 * @param modifier modifiers to set to this composable
 */
@Composable
fun DogItem(dog: Dog, modifier: Modifier = Modifier) {
  var expanded by remember { mutableStateOf(false) }
  Card(
    shape = WoofShapes.medium,
    modifier = modifier.padding(8.dp),
    elevation = 4.dp
  ) {
    Column(
      modifier = Modifier
        .animateContentSize(
          animationSpec = spring(
            dampingRatio = Spring.DampingRatioMediumBouncy,
            stiffness = Spring.StiffnessLow
          )
        )
    ) {
      Row(
        modifier = Modifier
          .fillMaxWidth()
          .padding(8.dp)
      ) {
        DogIcon(dog.imageResourceId)
        DogInformation(dog.name, dog.age)
        Spacer(Modifier.weight(1f))
        DogItemButton(
          expanded = expanded,
          onClick = { expanded = !expanded }
        )
      }
      if (expanded) {
        DogHobby(dogHobby = dog.hobbies)
      }
    }
  }
}

@Composable
private fun DogItemButton(
  expanded: Boolean,
  onClick: () -> Unit,
  modifier: Modifier = Modifier
) {
  IconButton(onClick = onClick) {
    Icon(
      imageVector = if (expanded) Icons.Filled.ExpandLess else Icons.Filled.ExpandMore,
      tint = MaterialTheme.colors.secondary,
      contentDescription = stringResource(id = R.string.expand_button_content_description)
    )
  }
}

/**
 * Composable that displays a photo of a dog.
 *
 * @param dogIcon is the resource ID for the image of the dog
 * @param modifier modifiers to set to this composable
 */
@Composable
fun DogIcon(@DrawableRes dogIcon: Int, modifier: Modifier = Modifier) {
  Image(
    modifier = modifier
      .size(64.dp)
      .padding(8.dp)
      .clip(RoundedCornerShape(50)),
    contentScale = ContentScale.Crop,
    painter = painterResource(dogIcon),
    /*
     * Content Description is not needed here - image is decorative, and setting a null content
     * description allows accessibility services to skip this element during navigation.
     */
    contentDescription = null
  )
}

/**
 * Composable that displays a dog's name and age.
 *
 * @param dogName is the resource ID for the string of the dog's name
 * @param dogAge is the Int that represents the dog's age
 * @param modifier modifiers to set to this composable
 */
@Composable
fun DogInformation(@StringRes dogName: Int, dogAge: Int, modifier: Modifier = Modifier) {
  Column {
    Text(
      text = stringResource(dogName),
      style = MaterialTheme.typography.h2,
      modifier = modifier.padding(top = 8.dp)
    )
    Text(
      text = stringResource(id = R.string.years_old, dogAge),
      style = MaterialTheme.typography.body1
    )
  }
}

@Composable
fun DogHobby(@StringRes dogHobby: Int, modifier: Modifier = Modifier) {
  Column(
    modifier = modifier.padding(
      start = 16.dp,
      top = 8.dp,
      bottom = 16.dp,
      end = 16.dp
    )
  ) {
    Text(
      text = stringResource(id = R.string.about),
      style = MaterialTheme.typography.h3
    )
    Text(
      text = stringResource(id = dogHobby),
      style = MaterialTheme.typography.body1
    )
  }
}

/**
 * Composable that displays what the UI of the app looks like in light theme in the design tab.
 */
@Preview
@Composable
fun WoofPreview() {
  WoofTheme(darkTheme = false) {
    WoofApp()
  }
}