package com.example.happybirthday.mars.model

import com.squareup.moshi.Json

data class MarsPhoto(
    @Json(name = "id") val id: String,
    @Json(name = "img_src") val imgSrcUrl: String
)
