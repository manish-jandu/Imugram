package com.manishjandu.libimgur

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

 enum class Section {
    @Json(name="hot")
    HOT,
    @Json(name="top")
    TOP
}