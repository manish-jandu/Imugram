package com.manishjandu.libimgur

import com.manishjandu.libimgur.models.Image
import com.manishjandu.libimgur.params.Section

class Wrapper {
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