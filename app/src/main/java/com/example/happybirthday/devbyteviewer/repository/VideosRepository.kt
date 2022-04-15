package com.example.happybirthday.devbyteviewer.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.Transformations
import com.example.happybirthday.devbyteviewer.database.VideosDatabase
import com.example.happybirthday.devbyteviewer.database.asDomainModel
import com.example.happybirthday.devbyteviewer.domain.DevByteVideo
import com.example.happybirthday.devbyteviewer.network.DevByteNetwork
import com.example.happybirthday.devbyteviewer.network.asDatabaseModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

/**
 * Repository for fetching devbyte videos from the network and storing them on disk
 */
// The repository pattern is a design pattern that isolates the data layer from the rest of the app. The data layer refers to the part of your app, separate from the UI, that handles the app's data and business logic, exposing consistent APIs for the rest of your app to access this data.
class VideosRepository(private val database: VideosDatabase) {
    suspend fun refreshVideos() {
        withContext(Dispatchers.IO) {
            val playlist = DevByteNetwork.devbytes.getPlaylist()
            database.videoDao.insertAll(playlist.asDatabaseModel())
        }
    }

    val videos: LiveData<List<DevByteVideo>> = Transformations.map(database.videoDao.getVideos()) {
        it.asDomainModel()
    }
}