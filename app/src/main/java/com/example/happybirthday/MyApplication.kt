package com.example.happybirthday

import android.app.Application
import com.example.happybirthday.busschedule.database.BusAppDatabase
import com.example.happybirthday.inventory.data.ItemRoomDatabase
import timber.log.Timber

class MyApplication: Application() {
    val database: BusAppDatabase by lazy { BusAppDatabase.getDatabase(this) }
    val itemDatabase: ItemRoomDatabase by lazy { ItemRoomDatabase.getDatabase(this) }

    /**
     * onCreate is called before the first screen is shown to the user.
     *
     * Use it to setup any background tasks, running expensive setup operations in a background
     * thread to avoid delaying app start.
     */
    override fun onCreate() {
        super.onCreate()
        Timber.plant(Timber.DebugTree())
    }
}