package com.example.happybirthday

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import androidx.core.content.ContextCompat.startActivity
import androidx.databinding.BindingAdapter
import androidx.databinding.DataBindingUtil
import com.example.happybirthday.affirmation.view.AffirmationActivity
import com.example.happybirthday.amphibians.ui.AmphibianActivity
import com.example.happybirthday.busschedule.ui.BusActivity
import com.example.happybirthday.cupcake.CupcakeActivity
import com.example.happybirthday.databinding.ActivityMainBinding
import com.example.happybirthday.devbyteviewer.ui.DevByteActivity
import com.example.happybirthday.dogglers.view.DogglersActivity
import com.example.happybirthday.inventory.ui.InventoryActivity
import com.example.happybirthday.lunchtray.ui.LunchActivity
import com.example.happybirthday.mars.ui.MarsActivity
import com.example.happybirthday.unscramble.ui.UnscrambleActivity
import com.example.happybirthday.words.view.WordActivity

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        val birthdayButton = findViewById<Button>(R.id.bt_birthday)
        birthdayButton.setOnClickListener {
            startActivity(Intent(this, BirthdayActivity::class.java))
        }

        binding.btDice.setOnClickListener {
            startActivity(Intent(this, DiceActivity::class.java))
        }
    }
}

@BindingAdapter("openActivity")
fun bindActivity(button: Button, appName: String) {
    val context = button.context
    val resources = button.resources
    val clazz = when (appName) {
        resources.getString(R.string.lemonade_app_name) -> LemonadeActivity::class.java
        resources.getString(R.string.tip_app_name) -> TipActivity::class.java
        resources.getString(R.string.affirmation_app_name) -> AffirmationActivity::class.java
        resources.getString(R.string.doggler_app_name) -> DogglersActivity::class.java
        resources.getString(R.string.words_app_name) -> WordActivity::class.java
        resources.getString(R.string.dessert_app_name) -> DessertActivity::class.java
        resources.getString(R.string.unscramble_app_name) -> UnscrambleActivity::class.java
        resources.getString(R.string.cupcake_app_name) -> CupcakeActivity::class.java
        resources.getString(R.string.lunch_app_name) -> LunchActivity::class.java
        resources.getString(R.string.mars_app_name) -> MarsActivity::class.java
        resources.getString(R.string.amphibians_app_name) -> AmphibianActivity::class.java
        resources.getString(R.string.bus_app_name) -> BusActivity::class.java
        resources.getString(R.string.inventory_app_name) -> InventoryActivity::class.java
        resources.getString(R.string.devbyte_app_name) -> DevByteActivity::class.java
        else -> MainActivity::class.java
    }

    button.setOnClickListener {
        startActivity(context, Intent(context, clazz), null)
    }
}