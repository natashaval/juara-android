package com.example.happybirthday.compose.model

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf

/**
 * Created by natasha.santoso on 07/11/22.
 */
data class WellnessTask(
  val id: Int,
  val label: String,
  val checked: MutableState<Boolean> = mutableStateOf(false)
)
