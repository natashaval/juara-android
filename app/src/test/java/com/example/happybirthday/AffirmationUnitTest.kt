package com.example.happybirthday

import android.content.Context
import com.example.happybirthday.affirmation.adapter.ItemAdapter
import com.example.happybirthday.affirmation.model.Affirmation
import org.junit.Assert.assertEquals
import org.junit.Test
import org.mockito.Mockito.mock

class AffirmationUnitTest {
  private val context = mock(Context::class.java)

  @Test
  fun adapter_size() {
    val data = listOf(
      Affirmation(R.string.affirmation1, R.drawable.image1),
      Affirmation(R.string.affirmation2, R.drawable.image2)
    )

    val adapter = ItemAdapter(context, data)
    assertEquals("ItemAdapter is not the correct size", data.size, adapter.itemCount)
  }
}