package com.example.happybirthday

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.example.happybirthday.affirmation.view.AffirmationActivity
import com.example.happybirthday.databinding.ActivityMainBinding
import kotlin.reflect.KClass

class MainActivity : AppCompatActivity() {
  private lateinit var binding: ActivityMainBinding
  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    binding = ActivityMainBinding.inflate(layoutInflater)
    setContentView(binding.root)

    val birthdayButton = findViewById<Button>(R.id.bt_birthday)
    birthdayButton.setOnClickListener {
      startActivity(Intent(this, BirthdayActivity::class.java))
    }
    
    val diceButton = findViewById<Button>(R.id.bt_dice)
    diceButton.setOnClickListener {
      startActivity(Intent(this, DiceActivity::class.java))
    }

    val lemonadeButton = findViewById<Button>(R.id.bt_lemonade)
    lemonadeButton.setOnClickListener {
      startActivity(Intent(this, LemonadeActivity::class.java))
    }

    binding.btTip.setOnClickListener {
      startActivity(Intent(this, TipActivity::class.java))
    }

    binding.btAffirmations.setOnClickListener {
      startActivity(Intent(this, AffirmationActivity::class.java))
    }
  }
}