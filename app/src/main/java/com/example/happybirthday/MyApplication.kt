package com.example.happybirthday

import android.app.Application
import com.example.happybirthday.busschedule.database.BusAppDatabase
import com.example.happybirthday.inventory.data.ItemRoomDatabase

class MyApplication: Application() {
    val database: BusAppDatabase by lazy { BusAppDatabase.getDatabase(this) }
    val itemDatabase: ItemRoomDatabase by lazy { ItemRoomDatabase.getDatabase(this) }
}