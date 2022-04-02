package com.example.happybirthday.words.view

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.happybirthday.R
import com.example.happybirthday.databinding.ActivityWordBinding
import com.example.happybirthday.words.adapter.LetterAdapter

class WordActivity: AppCompatActivity() {
  private lateinit var binding: ActivityWordBinding
  private var isLinearLayoutManager = true

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)

    binding = ActivityWordBinding.inflate(layoutInflater)
    setContentView(binding.root)

    chooseLayout()
  }

  private fun chooseLayout() {
    with(binding.recyclerView) {
      if (isLinearLayoutManager) {
        layoutManager = LinearLayoutManager(this@WordActivity)
      } else {
        layoutManager = GridLayoutManager(this@WordActivity, 4)
      }
      adapter = LetterAdapter()
    }
  }

  override fun onCreateOptionsMenu(menu: Menu?): Boolean {
    menuInflater.inflate(R.menu.layout_menu, menu)

    val layoutButton = menu?.findItem(R.id.action_switch_layout)
    // Calls code to set the icon based on the LinearLayoutManager of the RecyclerView
    setIcon(layoutButton)

    return true
  }

  override fun onOptionsItemSelected(item: MenuItem): Boolean {
    return when (item.itemId) {
      R.id.action_switch_layout -> {
        // Sets isLinearLayoutManager (a Boolean) to the opposite value
        isLinearLayoutManager = !isLinearLayoutManager
        // Sets layout and icon
        chooseLayout()
        setIcon(item)

        return true
      }
      //  Otherwise, do nothing and use the core event handling

      // when clauses require that all possible paths be accounted for explicitly,
      //  for instance both the true and false cases if the value is a Boolean,
      //  or an else to catch all unhandled cases.
      else -> super.onOptionsItemSelected(item)
    }
  }

  private fun setIcon(menuItem: MenuItem?) {
    if (menuItem == null) return

    // Set the drawable for the menu icon based on which LayoutManager is currently in use

    // An if-clause can be used on the right side of an assignment if all paths return a value.
    menuItem.icon =
      if (isLinearLayoutManager)
        ContextCompat.getDrawable(this, R.drawable.ic_grid_layout)
      else ContextCompat.getDrawable(this, R.drawable.ic_linear_layout)
  }
}