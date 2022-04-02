package com.example.happybirthday.words.view

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.happybirthday.R
import com.example.happybirthday.databinding.ActivityDetailBinding
import com.example.happybirthday.words.adapter.WordAdapter

class DetailActivity : AppCompatActivity() {

  // A companion object is similar to other objects, such as instances of a class.
  // However, only a single instance of a companion object will exist for the duration of your program,
  // which is why this is sometimes called the singleton pattern.
  companion object {
    const val LETTER = "letter"
    const val SEARCH_PREFIX = "https://www.google.com/search?q="
  }

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)

    // Retrieve a binding object that allows you to refer to views by id name
    // Names are converted from snake case to camel case.
    // For example, a View with the id word_one is referenced as binding.wordOne
    val binding = ActivityDetailBinding.inflate(layoutInflater)
    setContentView(binding.root)

    // Retrieve the LETTER from the Intent extras
    // intent.extras.getString returns String? (String or null)
    // so toString() guarantees that the value will be a String
    val letterId = intent?.extras?.getString(LETTER).toString()

    val recyclerView = binding.recyclerView
    recyclerView.layoutManager = LinearLayoutManager(this)
    recyclerView.adapter = WordAdapter(letterId, this)

    // Adds a [DividerItemDecoration] between items
    recyclerView.addItemDecoration(
      DividerItemDecoration(this, DividerItemDecoration.VERTICAL)
    )

    title = getString(R.string.detail_prefix) + " " + letterId
  }
}