package com.example.happybirthday

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView

/**
 * This activity allows the user to roll a dice and view the result
 * on the screen.
 */
// https://developer.android.com/courses/pathways/android-basics-kotlin-four
class DiceActivity : AppCompatActivity() {
  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_dice)

    val rollButton: Button = findViewById(R.id.bt_roll)

    rollButton.setOnClickListener {
      rollDice()
    }

    // Do a dice roll when the app starts
    rollDice()
  }

  /**
   * Roll the dice and update the screen with the result.
   */
  private fun rollDice() {
    // Create new Dice object with 6 sides and roll it
    val dice = Dice(6)
    val diceRoll = dice.roll()
    val diceRoll2 = dice.roll()

    // Update the screen with the dice roll
    val diceImage: ImageView = findViewById(R.id.iv_dice)
    val diceImage2: ImageView = findViewById(R.id.iv_dice2)

    // Update the ImageView with the correct drawable resource ID
    diceImage.setImageResource(getDiceDrawable(diceRoll))
    diceImage2.setImageResource(getDiceDrawable(diceRoll2))

    // Update the content description
    diceImage.contentDescription = diceRoll.toString()
    diceImage2.contentDescription = diceRoll2.toString()
  }

  private fun getDiceDrawable(diceRoll: Int): Int {
    return when (diceRoll) {
      1 -> R.drawable.dice_1
      2 -> R.drawable.dice_2
      3 -> R.drawable.dice_3
      4 -> R.drawable.dice_4
      5 -> R.drawable.dice_5
      else -> R.drawable.dice_6
    }
  }
}

class Dice(val numSides: Int) {

  fun roll(): Int {
    return (1 .. numSides).random()
  }
}