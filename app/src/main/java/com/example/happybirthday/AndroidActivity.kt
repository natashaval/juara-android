package com.example.happybirthday

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.happybirthday.databinding.ActivityAndroidBinding

class AndroidActivity : AppCompatActivity() {
  private lateinit var binding: ActivityAndroidBinding

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    binding = ActivityAndroidBinding.inflate(layoutInflater)
    setContentView(binding.root)

    with(binding) {
      btSeason1.setOnClickListener {
        startActivity(Intent(this@AndroidActivity, MainActivity::class.java))
      }
      btSeason2.setOnClickListener {
        startActivity(Intent(this@AndroidActivity, com.example.happybirthday.compose.view.BirthdayActivity::class.java))
      }
    }
  }
}