package com.manishjandu.libimgur.apis

import com.manishjandu.libimgur.ImgurClient
import com.manishjandu.libimgur.Section
import com.manishjandu.libimgur.models.Image
import kotlinx.coroutines.runBlocking
import org.junit.Assert
import org.junit.Test

class ImgurAPIv3Tests {

    private val api =  ImgurClient.api

    @Test
    fun getTagsWorking() = runBlocking{
        val response = api.getTags()
        Assert.assertNotNull(response.body())
    }

    @Test
    fun getGalleriesWorkingTop()= runBlocking{
        val response = api.getGallery(Section.TOP)
        val new: Int? = response.body()?.data?.size
        print(new)
        Assert.assertNotNull(response.body())
    }

    @Test
    fun getGalleriesWorkingHot()= runBlocking{
        val response = api.getGallery(Section.HOT)
        Assert.assertNotNull(response.body())
    }
}