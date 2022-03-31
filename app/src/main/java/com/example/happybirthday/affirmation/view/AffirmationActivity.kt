package com.example.happybirthday.affirmation.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.StaggeredGridLayoutManager
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
    with(binding.recyclerView) {
      adapter = ItemAdapter(this@AffirmationActivity, myDataset)

      // Use this setting to improve performance if you know that changes
      // in content do not change the layout size of the RecyclerView
      setHasFixedSize(true)
      layoutManager = StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL)
    }
  }
}