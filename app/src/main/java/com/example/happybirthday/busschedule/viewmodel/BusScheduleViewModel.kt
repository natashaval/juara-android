package com.example.happybirthday.busschedule.viewmodel

import androidx.lifecycle.ViewModel
import com.example.happybirthday.busschedule.database.Schedule
import com.example.happybirthday.busschedule.database.ScheduleDao
import kotlinx.coroutines.flow.Flow

class BusScheduleViewModel(private val scheduleDao: ScheduleDao): ViewModel() {
    fun fullSchedule(): Flow<List<Schedule>> = scheduleDao.getAll()

    fun scheduleForStopName(name: String): Flow<List<Schedule>> = scheduleDao.getByStopName(name)
}