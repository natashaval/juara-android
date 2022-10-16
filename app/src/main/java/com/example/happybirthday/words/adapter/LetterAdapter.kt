package com.example.happybirthday.words.adapter

import android.content.Intent
import android.os.Build
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.accessibility.AccessibilityNodeInfo
import android.widget.Button
import androidx.annotation.RequiresApi
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.example.happybirthday.R
import com.example.happybirthday.words.view.LetterListFragmentDirections
import com.example.happybirthday.words.view.WordListFragment

/**
 * Adapter for the [RecyclerView] in [MainActivity].
 */
class LetterAdapter :
  RecyclerView.Adapter<LetterAdapter.LetterViewHolder>() {

  // Generates a [CharRange] from 'A' to 'Z' and converts it to a list
  private val list = ('A').rangeTo('Z').toList()

  /**
   * Provides a reference for the views needed to display items in your list.
   */
  class LetterViewHolder(val view: View) : RecyclerView.ViewHolder(view) {
    val button = view.findViewById<Button>(R.id.button_item)
  }

  override fun getItemCount(): Int {
    return list.size
  }

  /**
   * Creates new views with R.layout.item_view as its template
   */
  override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): LetterViewHolder {
    val layout = LayoutInflater
      .from(parent.context)
      .inflate(R.layout.item_word_view, parent, false)
    // Setup custom accessibility delegate to set the text read
    layout.accessibilityDelegate = Accessibility
    return LetterViewHolder(layout)
  }

  /**
   * Replaces the content of an existing view with new data
   */
  override fun onBindViewHolder(holder: LetterViewHolder, position: Int) {
    val item = list[position]
    holder.button.text = item.toString()
    holder.button.setOnClickListener {
      val action =
        LetterListFragmentDirections.actionLetterListFragmentToWordListFragment(
          holder.button.text.toString()
        )
      holder.view.findNavController().navigate(action)
    }
  }

  // Setup custom accessibility delegate to set the text read with
  // an accessibility service
  companion object Accessibility : View.AccessibilityDelegate() {
    override fun onInitializeAccessibilityNodeInfo(host: View, info: AccessibilityNodeInfo) {
      super.onInitializeAccessibilityNodeInfo(host, info)
      // With `null` as the second argument to [AccessibilityAction], the
      // accessibility service announces "double tap to activate".
      // If a custom string is provided,
      // it announces "double tap to <custom string>".
      val customString = host.context?.getString(R.string.look_up_words)
      val customClick =
        AccessibilityNodeInfo.AccessibilityAction(
          AccessibilityNodeInfo.ACTION_CLICK,
          customString
        )
      info.addAction(customClick)
    }
  }
}