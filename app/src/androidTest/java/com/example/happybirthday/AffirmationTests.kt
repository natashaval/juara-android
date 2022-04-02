package com.example.happybirthday

import androidx.recyclerview.widget.RecyclerView
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.contrib.RecyclerViewActions
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.example.happybirthday.affirmation.view.AffirmationActivity
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class AffirmationTests {
  @get:Rule
  val activity = ActivityScenarioRule(AffirmationActivity::class.java)

  @Test
  fun scroll_to_last_affirmation() {
    onView(withId(R.id.recycler_view)).perform(RecyclerViewActions
      .scrollToPosition<RecyclerView.ViewHolder>(9))

    onView(withText(R.string.affirmation10)).check(matches(isDisplayed()))
  }

  @Test
  fun scroll_to_affirmation_string() {
    // Not working
    // Error performing 'scroll RecyclerView to: holder with view: an instance of android.widget.TextView and view.getText() equals string from resource id: <2131689500>' on view 'view.getId() is <2131231078/com.example.happybirthday:id/recycler_view>'
    onView(withId(R.id.recycler_view)).perform(
      RecyclerViewActions.scrollTo<RecyclerView.ViewHolder>(withText(R.string.affirmation10))
    )

    onView(withText(R.string.affirmation10)).check(matches(isDisplayed()))
  }
}