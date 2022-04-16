package com.example.happybirthday.waterme.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.recyclerview.widget.RecyclerView
import com.example.happybirthday.R
import com.example.happybirthday.waterme.adapter.PlantAdapter
import com.example.happybirthday.waterme.adapter.PlantListener
import com.example.happybirthday.waterme.viewmodel.PlantViewModel
import com.example.happybirthday.waterme.viewmodel.PlantViewModelFactory

class WaterActivity : AppCompatActivity() {

    private val viewModel: PlantViewModel by viewModels {
        PlantViewModelFactory(application)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_water)

        val adapter = PlantAdapter(PlantListener { plant ->
            val dialog = ReminderDialogFragment(plant.name)
            dialog.show(supportFragmentManager, "WaterReminderDialogFragment")
            true
        })
        val recyclerView: RecyclerView = findViewById(R.id.recycler_view)
        recyclerView.adapter = adapter
        val data = viewModel.plants
        adapter.submitList(data)
    }
}