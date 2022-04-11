package com.example.happybirthday

import android.app.Application
import com.example.happybirthday.busschedule.database.BusAppDatabase

class MyApplication: Application() {
    val database: BusAppDatabase by lazy { BusAppDatabase.getDatabase(this) }
}