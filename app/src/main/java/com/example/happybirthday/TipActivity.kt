package com.example.happybirthday

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.KeyEvent
import android.view.View
import android.view.inputmethod.InputMethodManager
import com.example.happybirthday.databinding.ActivityTipBinding
import java.text.NumberFormat
import kotlin.math.ceil

// https://developer.android.com/courses/pathways/android-basics-kotlin-unit-2-pathway-1
class TipActivity : AppCompatActivity() {

  // The lateinit keyword is something new. It's a promise that your code will initialize the variable before using it.
  lateinit var binding: ActivityTipBinding

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    binding = ActivityTipBinding.inflate(layoutInflater)
    setContentView(binding.root)

  // The binding object automatically defines references for every View in your app that has an ID.
  //  Using view binding is so much more concise that often you won't even need to create a variable to hold the reference for a View, just use it directly from the binding object.
    binding.calculateButton.setOnClickListener { calculateTip() }

    binding.costOfServiceEditText.setOnKeyListener { view, keyCode, _ -> handleKeyEvent(view, keyCode) }
  }

  private fun calculateTip() {
    val stringInTextField = binding.costOfServiceEditText.text.toString()
    val cost = stringInTextField.toDoubleOrNull()
    if (cost == null || cost == 0.0) {
      displayTip(0.0)
      return
    }
    val tipPercentage = when (binding.tipOptions.checkedRadioButtonId) {
      R.id.option_twenty_percent -> 0.20
      R.id.option_eighteen_percent -> 0.18
      else -> 0.15
    }
    var tip = tipPercentage * cost
    if (binding.roundUpSwitch.isChecked) {
      tip = ceil(tip)
    }
    displayTip(tip)
  }

  private fun displayTip(tip: Double) {
    val formattedTip = NumberFormat.getCurrencyInstance().format(tip)
    binding.tipResult.text = getString(R.string.tip_amount, formattedTip)
  }

  private fun handleKeyEvent(view: View, keyCode: Int): Boolean {
    if (keyCode == KeyEvent.KEYCODE_ENTER) {
      // Hide the keyboard
      val inputMethodManager =
        getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
      inputMethodManager.hideSoftInputFromWindow(view.windowToken, 0)
      return true
    }
    return false
  }
}