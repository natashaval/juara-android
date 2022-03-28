package com.example.happybirthday

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log

private const val TAG = "DebugActivity"

class DebugActivity : AppCompatActivity() {
  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_debug)
    logging()
    division()
  }

  fun logging() {
    Log.e(TAG, "ERROR: a serious error like an app crash")
    Log.w(TAG, "WARN: warns about the potential for serious errors")
    Log.i(TAG, "INFO: reporting technical information, such as an operation succeeding")
    Log.d(TAG, "DEBUG: reporting technical information useful for debugging")
    Log.v(TAG, "VERBOSE: more verbose than DEBUG logs")
  }

  fun division() {
    val numerator = 60
    var denominator = 4
    repeat(4) {
      Log.v(TAG, "${numerator / denominator}")
      denominator--
    }
  }
}