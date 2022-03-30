package com.example.happybirthday

import androidx.test.espresso.Espresso.closeSoftKeyboard
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.action.ViewActions.typeText
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.espresso.matcher.ViewMatchers.withText
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import org.hamcrest.Matchers.containsString
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

// https://developer.android.com/codelabs/android-basics-kotlin-write-instrumentation-tests?authuser=2&continue=https%3A%2F%2Fdeveloper.android.com%2Fcourses%2Fpathways%2Fandroid-basics-kotlin-unit-2-pathway-2%3Fauthuser%3D2%23codelab-https%3A%2F%2Fdeveloper.android.com%2Fcodelabs%2Fandroid-basics-kotlin-write-instrumentation-tests#3

@RunWith(AndroidJUnit4::class)
class CalculatorTests {
  // ActivityScenarioRule comes from the AndroidX Test library. It tells the device to launch an activity specified by the developer
  @get:Rule()
  val activity = ActivityScenarioRule(TipActivity::class.java)

  @Test
  fun calculate_20_percent_tip() {
    onView(withId(R.id.cost_of_service_edit_text)).perform(typeText("50.00"))
    // Error performing 'single click' on view 'Animations or transitions are enabled on the target device
    // because button "Calculate" is hidden behind the keyboard
    closeSoftKeyboard()
    onView(withId(R.id.calculate_button)).perform(click())
    onView(withId(R.id.tip_result)).check(matches(withText(containsString("$10.00"))))
  }

  @Test
  fun calculate_18_percent_tip() {
    onView(withId(R.id.cost_of_service_edit_text)).perform(typeText("50.00"))
    closeSoftKeyboard()
    onView(withId(R.id.option_eighteen_percent)).perform(click())
    onView(withId(R.id.calculate_button)).perform(click())
    onView(withId(R.id.tip_result)).check(matches(withText(containsString("$9.00"))))
  }

  @Test
  fun calculate_15_percent_tip() {
    onView(withId(R.id.cost_of_service_edit_text)).perform(typeText("50.00"))
    closeSoftKeyboard()
    onView(withId(R.id.option_fifteen_percent)).perform(click())
    onView(withId(R.id.calculate_button)).perform(click())
    onView(withId(R.id.tip_result)).check(matches(withText(containsString("$8.00"))))
  }

  @Test
  fun calculate_15_percent_tip_no_ceil() {
    onView(withId(R.id.cost_of_service_edit_text)).perform(typeText("50.00"))
    closeSoftKeyboard()
    onView(withId(R.id.option_fifteen_percent)).perform(click())
    onView(withId(R.id.round_up_switch)).perform(click())
    onView(withId(R.id.calculate_button)).perform(click())
    onView(withId(R.id.tip_result)).check(matches(withText(containsString("$7.50"))))
  }
}