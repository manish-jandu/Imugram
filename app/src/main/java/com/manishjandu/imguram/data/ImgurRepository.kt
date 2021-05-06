package com.manishjandu.imguram.data

import android.util.Log
import com.manishjandu.libimgur.ImgurClient
import com.manishjandu.libimgur.Section
import com.manishjandu.libimgur.models.Image

class ImgurRepository {
    val api = ImgurClient.api

    suspend fun getHotFeed(): List<Image>? { // TODO: return a proper error object if null
        val response = api.getGallery(Section.HOT)
        return response.body()?.data
    }

    suspend fun getTopFeed(): List<Image>? {
        val response = api.getGallery(Section.TOP )
        return response.body()?.data
    }
}