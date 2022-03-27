package com.example.happybirthday

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity : AppCompatActivity() {
  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_main)

    val birthdayButton = findViewById<Button>(R.id.bt_birthday)
    birthdayButton.setOnClickListener {
      startActivity(Intent(this, BirthdayActivity::class.java))
    }
    
    val diceButton = findViewById<Button>(R.id.bt_dice)
    diceButton.setOnClickListener {
      startActivity(Intent(this, DiceActivity::class.java))
    }
  }
}