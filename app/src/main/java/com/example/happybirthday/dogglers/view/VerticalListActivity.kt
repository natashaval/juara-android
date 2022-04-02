package com.example.happybirthday.dogglers.view

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.happybirthday.databinding.ActivityVerticalListBinding
import com.example.happybirthday.dogglers.adapter.DogCardAdapter
import com.example.happybirthday.dogglers.const.Layout

class VerticalListActivity : AppCompatActivity() {

  private lateinit var binding: ActivityVerticalListBinding

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    binding = ActivityVerticalListBinding.inflate(layoutInflater)
    setContentView(binding.root)

    binding.verticalRecyclerView.adapter = DogCardAdapter(
      applicationContext,
      Layout.VERTICAL
    )

    // Specify fixed size to improve performance
    binding.verticalRecyclerView.setHasFixedSize(true)

    // Enable up button for backward navigation
    supportActionBar?.setDisplayHomeAsUpEnabled(true)
  }
}