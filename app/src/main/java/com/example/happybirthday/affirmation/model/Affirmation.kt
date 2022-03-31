package com.example.happybirthday.affirmation.model

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes

data class Affirmation(
  // add the @StringRes annotation to your string resource ID property and @DrawableRes annotation to your drawable resource ID property.
  // Then you will get a warning if you supply the wrong type of resource ID.
  @StringRes val stringResourceId: Int,
  @DrawableRes val imageResourceId: Int
)
