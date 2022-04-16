package com.example.happybirthday.waterme

import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.action.ViewActions.longClick
import androidx.test.espresso.matcher.ViewMatchers.withText
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.platform.app.InstrumentationRegistry.getInstrumentation
import androidx.test.uiautomator.By
import androidx.test.uiautomator.UiDevice
import androidx.test.uiautomator.UiSelector
import androidx.test.uiautomator.Until
import com.example.happybirthday.waterme.ui.WaterActivity
import org.junit.Assert.assertTrue
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class NotificationTest {

    private val timeout: Long = 6000

    private val plantName = "Carrot"

    @get:Rule
    var activityRule: ActivityScenarioRule<WaterActivity>
            = ActivityScenarioRule(WaterActivity::class.java)

    private lateinit var uiDevice: UiDevice

    @Before
    fun setup() {
        uiDevice = UiDevice.getInstance(getInstrumentation())
        onView(withText("Carrot")).perform(longClick())
        onView(withText("5 seconds")).perform(click())
        uiDevice.pressHome()
        uiDevice.openNotification()
        uiDevice.wait(Until.hasObject(By.textContains(plantName)), timeout)
    }

    @Test
    fun notification_scheduled() {
        val notification = uiDevice.findObject(UiSelector().textContains(plantName)).exists()
        assertTrue("Could not find text 'Carrot'", notification)
        uiDevice.pressHome()
    }

    @Test
    fun notification_click() {
        val notification = uiDevice.findObject(UiSelector().textContains("Carrot"))
        notification.click()
        uiDevice.wait(Until.hasObject(By.pkg("com.example.happybirthday")
            .depth(0)), 1000)
        val pkg = uiDevice.findObject(UiSelector().packageName("com.example.happybirthday"))
            .exists()
        assertTrue("Could not find package", pkg)
    }
}