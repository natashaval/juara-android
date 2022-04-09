package com.example.happybirthday.mars.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.happybirthday.mars.model.MarsPhoto
import com.example.happybirthday.mars.network.MarsApi
import kotlinx.coroutines.launch
import java.lang.Exception

/**
 * The [ViewModel] that is attached to the [OverviewFragment].
 */
class OverviewViewModel : ViewModel() {

    // The internal MutableLiveData that stores the status of the most recent request
    private val _status = MutableLiveData<String>()

    // The external immutable LiveData for the request status
    val status: LiveData<String> = _status

    private val _photos = MutableLiveData<MarsPhoto>()
    val photos: LiveData<MarsPhoto> = _photos
    /**
     * Call getMarsPhotos() on init so we can display status immediately.
     */
    init {
        getMarsPhotos()
    }

    /**
     * Gets Mars photos information from the Mars API Retrofit service and updates the
     * [MarsPhoto] [List] [LiveData].
     */
    private fun getMarsPhotos() {
        viewModelScope.launch {
            try {
                val listResult = MarsApi.retrofitService.getPhotos()
                _photos.value = listResult[0]
                _status.value = "   First Mars image URL: ${_photos.value!!.imgSrcUrl}"
            } catch (e: Exception) {
                _status.value = "Failure: ${e.message}"
            }
        }
    }
}
