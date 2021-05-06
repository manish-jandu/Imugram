package com.manishjandu.libimgur

import com.manishjandu.libimgur.apis.ImgurAPIv3
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

object ImgurClient {
    const val API_KEY = "81db23a1db126d4"//TODO:ideally should be in app not in lib
    const val BASE_URL = "https://api.imgur.com/3/"

    private val httpClient: OkHttpClient by lazy {
        OkHttpClient.Builder()
            .addInterceptor {
                val request = it.request().newBuilder()
                    .addHeader("Authorization", "Client-ID $API_KEY")
                    .build()
                it.proceed(request)
            }
            .build()
    }

    private val retrofit: Retrofit by lazy {
        Retrofit.Builder()
            .client(httpClient)
            .addConverterFactory(MoshiConverterFactory.create())
            .addConverterFactory(EnumConvertorFactory())
            .baseUrl(BASE_URL)
            .build()
    }

    val api: ImgurAPIv3 by lazy {
        retrofit.create(ImgurAPIv3::class.java)
    }
}