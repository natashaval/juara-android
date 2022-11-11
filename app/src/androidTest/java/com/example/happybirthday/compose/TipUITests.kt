package com.example.happybirthday.compose

import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.performTextInput
import com.example.happybirthday.compose.view.TipTimeScreen
import com.example.happybirthday.compose.view.ui.theme.HappyBirthdayTheme
import org.junit.Rule
import org.junit.Test

/**
 * Created by natasha.santoso on 17/10/22.
 */
class TipUITests {
  @get:Rule
  val composeTestRule = createComposeRule()

  @Test
  fun calculate_20_percent_tip() {
    composeTestRule.setContent {
      HappyBirthdayTheme {
        TipTimeScreen()
      }
    }
    composeTestRule.onNodeWithText("Bill Amount").performTextInput("10")
    composeTestRule.onNodeWithText("Tip (%)").performTextInput("20")
    composeTestRule.onNodeWithText("Tip Amount: $2.00", useUnmergedTree = true).assertExists()
  }
}