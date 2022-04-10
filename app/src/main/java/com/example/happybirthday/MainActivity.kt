package com.example.happybirthday

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.example.happybirthday.affirmation.view.AffirmationActivity
import com.example.happybirthday.amphibians.ui.AmphibianActivity
import com.example.happybirthday.cupcake.CupcakeActivity
import com.example.happybirthday.databinding.ActivityMainBinding
import com.example.happybirthday.dogglers.view.DogglersActivity
import com.example.happybirthday.lunchtray.ui.LunchActivity
import com.example.happybirthday.mars.ui.MarsActivity
import com.example.happybirthday.unscramble.ui.UnscrambleActivity
import com.example.happybirthday.words.view.WordActivity

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

    binding.btDogglers.setOnClickListener {
      startActivity(Intent(this, DogglersActivity::class.java))
    }

    binding.btWords.setOnClickListener {
      startActivity(Intent(this, WordActivity::class.java))
    }

    binding.btDessert.setOnClickListener {
      startActivity(Intent(this, DessertActivity::class.java))
    }

    binding.btUnscramble.setOnClickListener {
      startActivity(Intent(this, UnscrambleActivity::class.java))
    }

    binding.btCupcake.setOnClickListener {
      startActivity(Intent(this, CupcakeActivity::class.java))
    }

    binding.btLunch.setOnClickListener {
      startActivity(Intent(this, LunchActivity::class.java))
    }

    binding.btMars.setOnClickListener {
      startActivity(Intent(this, MarsActivity::class.java))
    }

    binding.btAmphibians.setOnClickListener {
      startActivity(Intent(this, AmphibianActivity::class.java))
    }
  }
}