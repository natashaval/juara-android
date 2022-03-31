package com.example.happybirthday.affirmation.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.happybirthday.affirmation.adapter.ItemAdapter
import com.example.happybirthday.affirmation.data.Datasource
import com.example.happybirthday.databinding.ActivityAffirmationBinding

class AffirmationActivity : AppCompatActivity() {
  private lateinit var binding: ActivityAffirmationBinding

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    binding = ActivityAffirmationBinding.inflate(layoutInflater)
    setContentView(binding.root)

    val myDataset = Datasource().loadAffirmations()
    binding.recyclerView.adapter = ItemAdapter(this, myDataset)

    // Use this setting to improve performance if you know that changes
    // in content do not change the layout size of the RecyclerView
    binding.recyclerView.setHasFixedSize(true)
  }
}