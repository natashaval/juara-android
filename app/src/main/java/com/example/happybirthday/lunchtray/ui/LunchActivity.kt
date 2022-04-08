package com.example.happybirthday.lunchtray.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.NavController
import com.example.happybirthday.R
import com.example.happybirthday.databinding.ActivityLunchBinding

class LunchActivity : AppCompatActivity() {

    // Binding object instance corresponding to the activity_main.xml layout
    // when the view hierarchy is attached to the fragment.
    private lateinit var binding: ActivityLunchBinding
    private lateinit var navController: NavController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityLunchBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // TODO: Retrieve NavController from the NavHostFragment
    }
}