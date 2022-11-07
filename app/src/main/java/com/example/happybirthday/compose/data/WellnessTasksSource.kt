package com.example.happybirthday.compose.data

import android.annotation.SuppressLint
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import com.example.happybirthday.compose.model.WellnessTask
import com.example.happybirthday.compose.view.WellnessTaskItem

/**
 * Created by natasha.santoso on 07/11/22.
 */
class WellnessTasksSource {
  fun getWellnessTasks() = List(30) { i -> WellnessTask(i, "Task # $i") }
}