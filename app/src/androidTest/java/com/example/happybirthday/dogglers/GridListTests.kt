package com.example.happybirthday.dogglers

import androidx.recyclerview.widget.RecyclerView
import androidx.test.espresso.Espresso
import androidx.test.espresso.action.ViewActions
import androidx.test.espresso.assertion.ViewAssertions
import androidx.test.espresso.contrib.RecyclerViewActions
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.filters.SmallTest
import com.example.happybirthday.R
import com.example.happybirthday.dogglers.BaseTest.DrawableMatcher.hasItemCount
import com.example.happybirthday.dogglers.view.GridListActivity
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
@SmallTest
class GridListTests : BaseTest() {

  @get:Rule
  var activityRule: ActivityScenarioRule<GridListActivity>
      = ActivityScenarioRule(GridListActivity::class.java)

  @Test
  fun `grid_list_content_at_first_position`() {
    checkFirstPosition()
  }

  @Test
  fun `grid_list_content_on_first_page`() {
    Espresso.onView(ViewMatchers.withText("Nox"))
      .check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
  }

  @Test
  fun `grid_list_content_at_last_position`() {
    Espresso.onView(withId(R.id.grid_recycler_view))
      .perform(RecyclerViewActions.scrollToPosition<RecyclerView.ViewHolder>(lastPosition))
    Espresso.onView(ViewMatchers.withText("Bella"))
      .check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
  }

  @Test
  fun `vertical_scrolling`() {
    Espresso.onView(withId(R.id.grid_recycler_view))
      .perform(ViewActions.swipeUp())
    Espresso.onView(ViewMatchers.withText("Bella"))
      .check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
  }

  @Test
  fun `recycler_view_item_count`() {
    Espresso.onView(withId(R.id.grid_recycler_view)).check(hasItemCount(6))
  }
}