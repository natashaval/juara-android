package com.example.happybirthday.dogglers.view

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.happybirthday.databinding.ActivityHorizontalListBinding
import com.example.happybirthday.dogglers.adapter.DogCardAdapter
import com.example.happybirthday.dogglers.const.Layout

class HorizontalListActivity : AppCompatActivity() {

  private lateinit var binding: ActivityHorizontalListBinding

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    binding = ActivityHorizontalListBinding.inflate(layoutInflater)
    setContentView(binding.root)

    binding.horizontalRecyclerView.adapter = DogCardAdapter(
      applicationContext,
      Layout.HORIZONTAL
    )

    // Specify fixed size to improve performance
    binding.horizontalRecyclerView.setHasFixedSize(true)

    // Enable up button for backward navigation
    supportActionBar?.setDisplayHomeAsUpEnabled(true)
  }
}