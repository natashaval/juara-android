package com.example.happybirthday

import android.app.Application
import android.app.NotificationChannel
import android.app.NotificationManager
import android.content.Context
import android.os.Build
import com.example.happybirthday.busschedule.database.BusAppDatabase
import com.example.happybirthday.forage.data.ForageDatabase
import com.example.happybirthday.inventory.data.ItemRoomDatabase
import timber.log.Timber

class MyApplication: Application() {
    val database: BusAppDatabase by lazy { BusAppDatabase.getDatabase(this) }
    val itemDatabase: ItemRoomDatabase by lazy { ItemRoomDatabase.getDatabase(this) }

    // TODO: provide a ForageDatabase value by lazy here
    val forageDatabase: ForageDatabase by lazy { ForageDatabase.getDatabase(this) }

    /**
     * onCreate is called before the first screen is shown to the user.
     *
     * Use it to setup any background tasks, running expensive setup operations in a background
     * thread to avoid delaying app start.
     */
    override fun onCreate() {
        super.onCreate()
        Timber.plant(Timber.DebugTree())

        // Water Me
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            val name = getString(R.string.channel_name)
            val descriptionText = getString(R.string.channel_description)
            val importance = NotificationManager.IMPORTANCE_DEFAULT
            val channel = NotificationChannel(CHANNEL_ID, name, importance).apply {
                description = descriptionText
            }
            // Register the channel with the system
            val notificationManager: NotificationManager =
                getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
            notificationManager.createNotificationChannel(channel)
        }
    }

    companion object {
        const val CHANNEL_ID = "water_reminder_id"
    }
}