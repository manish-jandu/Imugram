package com.manishjandu.libimgur.apis

import com.manishjandu.libimgur.models.GalleryResponse
import com.manishjandu.libimgur.models.TagsResponse
import retrofit2.Call
import retrofit2.http.GET

interface ImgurAPIv3 {
    @GET("gallery/hot?&album_previews=true") //TODO: use path params
    fun getGallery():Call<GalleryResponse>

    @GET("tags")
    fun getTags():Call<TagsResponse>



}