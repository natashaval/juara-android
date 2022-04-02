package com.example.happybirthday.dogglers.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.happybirthday.R
import com.example.happybirthday.dogglers.const.Layout
import com.example.happybirthday.dogglers.data.DataSource

/**
 * Adapter to inflate the appropriate list item layout and populate the view with information
 * from the appropriate data source
 */
class DogCardAdapter(
  private val context: Context?,
  private val layout: Int
): RecyclerView.Adapter<DogCardAdapter.DogCardViewHolder>() {

  // TODO: Initialize the data using the List found in data/DataSource
  private val dogList = DataSource.dogs

  /**
   * Initialize view elements
   */
  class DogCardViewHolder(view: View?): RecyclerView.ViewHolder(view!!) {
    // TODO: Declare and initialize all of the list item UI components
    val imageDog = view?.findViewById<ImageView>(R.id.iv_dog)
    val textName = view?.findViewById<TextView>(R.id.tv_dog_name)
    val textAge = view?.findViewById<TextView>(R.id.tv_dog_age)
    val textHobby = view?.findViewById<TextView>(R.id.tv_dog_hobby)
  }

  override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DogCardViewHolder {
    // TODO: Use a conditional to determine the layout type and set it accordingly.
    //  if the layout variable is Layout.GRID the grid list item should be used. Otherwise the
    //  the vertical/horizontal list item should be used.
    val layout = when (layout) {
      Layout.GRID -> LayoutInflater.from(parent.context).inflate(R.layout.grid_list_item, parent, false)
      else -> LayoutInflater.from(parent.context).inflate(R.layout.vertical_horizontal_list_item, parent, false)
    }
    // TODO Inflate the layout

    // TODO: Null should not be passed into the view holder. This should be updated to reflect
    //  the inflated layout.
    return DogCardViewHolder(layout)
  }

  override fun getItemCount(): Int = dogList.size

  override fun onBindViewHolder(holder: DogCardViewHolder, position: Int) {
    // TODO: Get the data at the current position
    val dog = dogList[position]
    with(holder) {
      // TODO: Set the image resource for the current dog
      imageDog?.setImageResource(dog.imageResourceId)
      // TODO: Set the text for the current dog's name
      textName?.text = dog.name

      val resources = context?.resources
      // TODO: Set the text for the current dog's age
      textAge?.text = resources?.getString(R.string.dog_age, dog.age)
      // TODO: Set the text for the current dog's hobbies by passing the hobbies to the
      //  R.string.dog_hobbies string constant.
      //  Passing an argument to the string resource looks like:
      //  resources?.getString(R.string.dog_hobbies, dog.hobbies)
      textHobby?.text = resources?.getString(R.string.dog_hobbies, dog.hobbies)
    }
  }
}