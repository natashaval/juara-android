package com.example.happybirthday.compose.model

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes

/**
 * Created by natasha.santoso on 24/10/22.
 */
data class Topic(
  @StringRes val stringResourceId: Int,
  val courses: Int,
  @DrawableRes val imageResourceId: Int
)
