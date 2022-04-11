package com.example.happybirthday.busschedule.viewmodel

import androidx.lifecycle.ViewModel
import com.example.happybirthday.busschedule.database.Schedule
import com.example.happybirthday.busschedule.database.ScheduleDao

class BusScheduleViewModel(private val scheduleDao: ScheduleDao): ViewModel() {
    fun fullSchedule(): List<Schedule> = scheduleDao.getAll()

    fun scheduleForStopName(name: String): List<Schedule> = scheduleDao.getByStopName(name)
}