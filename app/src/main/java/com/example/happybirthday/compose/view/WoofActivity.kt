package com.example.happybirthday.compose.view

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
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
        .padding(padding)) {
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
  Card(
    shape = WoofShapes.medium,
    modifier = modifier.padding(8.dp),
    elevation = 4.dp
  ) {
    Row(
      modifier = Modifier
        .fillMaxWidth()
        .padding(8.dp)
    ) {
      DogIcon(dog.imageResourceId)
      DogInformation(dog.name, dog.age)
    }
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

/**
 * Composable that displays what the UI of the app looks like in light theme in the design tab.
 */
@Preview
@Composable
fun WoofPreview() {
  WoofTheme(darkTheme = true) {
    WoofApp()
  }
}