package com.manishjandu.libimgur.apis

import okhttp3.OkHttpClient
import org.junit.Assert
import org.junit.Test
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

class ImgurAPIv3Tests {
    private val client = OkHttpClient.Builder()
        .addInterceptor{
            val request = it.request().newBuilder()
                .addHeader("Authorization","Client-ID 81db23a1db126d4")
                .build()
            it.proceed(request)
        }.build()

    private val retrofit= Retrofit.Builder()
        .client(client )
        .addConverterFactory(MoshiConverterFactory.create())
        .baseUrl("https://api.imgur.com/3/")
        .build()
    private val api = retrofit.create(ImgurAPIv3::class.java)

    @Test
    fun getTagsWorking() {
        val response = api.getTags().execute()
        Assert.assertNotNull(response.body())
    }

    @Test
    fun getGalleriesWorking(){
        val response = api.getGallery().execute()
        Assert.assertNotNull(response.body())
    }

}