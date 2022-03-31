package com.example.happybirthday.affirmation.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.happybirthday.R
import com.example.happybirthday.affirmation.model.Affirmation

// https://developer.android.com/codelabs/basic-android-kotlin-training-recyclerview-scrollable-list?authuser=2&continue=https%3A%2F%2Fdeveloper.android.com%2Fcourses%2Fpathways%2Fandroid-basics-kotlin-unit-2-pathway-3%3Fauthuser%3D2%23codelab-https%3A%2F%2Fdeveloper.android.com%2Fcodelabs%2Fbasic-android-kotlin-training-recyclerview-scrollable-list#3
/*
  Adapter is a design pattern that adapts the data into something that can be used by RecyclerView.
  In this case, you need an adapter that takes an Affirmation instance from the list returned by loadAffirmations(),
  and turns it into a list item view, so that it can be displayed in the RecyclerView.
 */
class ItemAdapter(private val context: Context, private val dataset: List<Affirmation>) :
  RecyclerView.Adapter<ItemAdapter.ItemViewHolder>() {

  /*
    A ViewHolder represents a single list item view in RecyclerView, and can be reused when possible.
    A ViewHolder instance holds references to the individual views within a list item layout (hence the name "view holder").
   */
  class ItemViewHolder(private val view: View) : RecyclerView.ViewHolder(view) {
    val textView: TextView = view.findViewById(R.id.item_title)
  }

  /**
   * Create new views (invoked by the layout manager)
   */
  override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
    // The onCreateViewHolder()method is called by the layout manager to create new view holders for the RecyclerView
    val adapterLayout = LayoutInflater.from(parent.context).inflate(R.layout.list_item, parent, false)
    return ItemViewHolder(adapterLayout)
  }

  /**
   * Replace the contents of a view (invoked by the layout manager)
   */
  override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
    // This method is called by the layout manager in order to replace the contents of a list item view.
    val item = dataset[position]
    holder.textView.text = context.resources.getString(item.stringResourceId)
  }

  /**
   * Return the size of your dataset (invoked by the layout manager)
   */
  override fun getItemCount(): Int = dataset.size
}