package com.example.happybirthday.words.view

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.happybirthday.databinding.ActivityWordBinding
import com.example.happybirthday.words.adapter.LetterAdapter

class WordActivity: AppCompatActivity() {
  private lateinit var binding: ActivityWordBinding

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)

    binding = ActivityWordBinding.inflate(layoutInflater)
    setContentView(binding.root)

    with(binding.recyclerView) {
      layoutManager = LinearLayoutManager(this@WordActivity)
      adapter = LetterAdapter()
    }
  }
}