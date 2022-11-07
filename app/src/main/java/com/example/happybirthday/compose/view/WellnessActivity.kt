package com.example.happybirthday.compose.view

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.happybirthday.compose.model.WellnessTask
import com.example.happybirthday.compose.view.ui.theme.HappyBirthdayTheme
import com.example.happybirthday.compose.viewmodel.WellnessViewModel

class WellnessActivity : ComponentActivity() {
  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContent {
      HappyBirthdayTheme {
        Surface(modifier = Modifier.fillMaxSize(), color = MaterialTheme.colors.background) {
          WellnessScreen()
        }
      }
    }
  }
}

@Composable
fun StatelessCounter(
  count: Int,
  onIncrement: () -> Unit,
  modifier: Modifier = Modifier
) {
  Column(modifier = modifier.padding(16.dp)) {
    if (count > 0) {
      Text(text = "You've had $count glasses.")
    }
    Button(onClick = onIncrement, modifier = Modifier.padding(top = 8.dp), enabled = count < 10) {
      Text("Add one")
    }
  }
}

@Composable
fun StatefulCounter(modifier: Modifier = Modifier) {
  var count by rememberSaveable { mutableStateOf(0) }
  StatelessCounter(count = count, onIncrement = { count++ }, modifier)
}

@Composable
fun WellnessTaskItem(
  taskName: String,
  checked: Boolean,
  onCheckedChange: (Boolean) -> Unit,
  onClose: () -> Unit,
  modifier: Modifier = Modifier
) {
  Row(
    modifier = modifier,
    verticalAlignment = Alignment.CenterVertically
  ) {
    Text(
      modifier = Modifier
        .weight(1f)
        .padding(start = 16.dp),
      text = taskName
    )
    Checkbox(
      checked = checked,
      onCheckedChange = onCheckedChange
    )
    IconButton(onClick = onClose) {
      Icon(
        imageVector = Icons.Filled.Close,
        contentDescription = "Close"
      )
    }
  }
}

@Composable
fun WellnessTaskItem(taskName: String,  onClose: () -> Unit, modifier: Modifier = Modifier) {
  var checkedState by rememberSaveable { mutableStateOf(false) }
  WellnessTaskItem(
    taskName = taskName,
    checked = checkedState,
    onCheckedChange = { newValue -> checkedState = newValue },
    onClose = onClose,
    modifier = modifier
  )
}


@Composable
fun WellnessTasksList(
  modifier: Modifier = Modifier,
  list: List<WellnessTask>,
  onCheckedTask: (WellnessTask, Boolean) -> Unit,
  onCloseTask: (WellnessTask) -> Unit
) {
  LazyColumn(
    modifier = modifier
  ) {
    items(
      items = list,
      key = { task -> task.id }
    ) { task ->
      WellnessTaskItem(
        taskName = task.label,
        checked = task.checked.value,
        onCheckedChange = { checked: Boolean -> onCheckedTask(task, checked) },
        onClose = { onCloseTask(task)}
      )
    }
  }
}

@Composable
fun WellnessScreen(
  modifier: Modifier = Modifier,
  wellnessViewModel: WellnessViewModel = viewModel()
) {
  Column(modifier = modifier) {
    StatefulCounter()

    val list = remember { wellnessViewModel.tasks }
    WellnessTasksList(
      list = list,
      onCheckedTask = { task, checked ->
        wellnessViewModel.changeTaskChecked(task, checked)
      },
      onCloseTask = { task -> wellnessViewModel.remove(task) }
    )
  }
}

@Preview(showBackground = true)
@Composable
fun WellnessPreview() {
  HappyBirthdayTheme {
    WellnessScreen()
  }
}