package com.example.happybirthday.compose.viewmodel

import androidx.compose.runtime.toMutableStateList
import androidx.lifecycle.ViewModel
import com.example.happybirthday.compose.model.WellnessTask

/**
 * Created by natasha.santoso on 07/11/22.
 */
class WellnessViewModel : ViewModel() {
  private val _tasks = getWellnessTasks().toMutableStateList()
  val tasks: List<WellnessTask>
    get() = _tasks

  fun remove(item: WellnessTask) {
    _tasks.remove(item)
  }

  fun changeTaskChecked(item: WellnessTask, checked: Boolean) {
    tasks.find { it.id == item.id }?.let { task ->
      task.checked.value = checked
    }
  }

  private fun getWellnessTasks() = List(30) { i -> WellnessTask(i, "Task # $i") }
}