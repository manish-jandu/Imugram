package com.manishjandu.imguram.data

import com.manishjandu.libimgur.ImgurClient.api
import com.manishjandu.libimgur.params.Section
import com.manishjandu.libimgur.models.Image
import com.manishjandu.libimgur.models.Tag

class ImgurRepository {

    suspend fun getHotFeed(): List<Image>? { // TODO: return a proper error object if null
        val response = api.getGallery(Section.HOT)
        return response.body()?.data
    }

    suspend fun getTopFeed(): List<Image>? {
        val response = api.getGallery(Section.TOP)
        return response.body()?.data
    }

    suspend fun getTags(): List<Tag>? {
        val response = api.getTags()
        return response.body()?.data?.tags
    }

    suspend fun getTagGallery(tagName:String):List<Image>?{
        val response = api.getTagGallery(tagName)
        return response.body()?.data?.items
    }
}