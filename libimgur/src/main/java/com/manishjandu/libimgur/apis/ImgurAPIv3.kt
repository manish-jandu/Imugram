package com.manishjandu.libimgur.apis

import com.manishjandu.libimgur.params.Section
import com.manishjandu.libimgur.models.GalleryResponse
import com.manishjandu.libimgur.models.TagsResponse
import com.scaler.libimgur.models.TagResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface ImgurAPIv3 {
    @GET("gallery/{section}") // TODO: use path params
    suspend fun getGallery(
        @Path("section") section: Section,
        @Query("album_previews") albumPreviews: Boolean? = true
    ): Response<GalleryResponse>

    @GET("tags")
    suspend fun getTags(): Response<TagsResponse>

    @GET("gallery/t/{tag}")
    suspend fun getTagGallery(
        @Path("tag") tag:String
    ) : Response<TagResponse>

}