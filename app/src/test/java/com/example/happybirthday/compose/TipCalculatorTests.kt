package com.example.happybirthday.compose

import com.example.happybirthday.compose.view.calculateTip
import org.junit.Assert.assertEquals
import org.junit.Test

/**
 * Created by natasha.santoso on 17/10/22.
 */
class TipCalculatorTests {
  @Test
  fun calculate_20_percent_tip_no_roundup() {
    val amount = 10.00
    val tipPercent = 20.00
    val expectedTip = "$2.00"
    val actualTip = calculateTip(amount, tipPercent, false)
    assertEquals(expectedTip, actualTip)
  }
}