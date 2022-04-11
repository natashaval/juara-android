package com.example.happybirthday.busschedule.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = arrayOf(Schedule::class), version = 1)
abstract class BusAppDatabase: RoomDatabase() {
    abstract fun scheduleDao(): ScheduleDao

    companion object {
        @Volatile
        private var INSTANCE: BusAppDatabase? = null

        fun getDatabase(context: Context): BusAppDatabase {
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context,
                    BusAppDatabase::class.java,
                    "app_database"
                ).createFromAsset("database/bus_schedule.db").build()
                INSTANCE = instance

                instance
            }
        }
    }
}