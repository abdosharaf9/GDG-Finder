package com.abdosharaf.gdgfinder.network

import com.abdosharaf.gdgfinder.Constants.BASE_URL
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.GET

interface GdgService {

    @GET("gdg-directory.json")
    suspend fun getChapters(): ChaptersResponse
}

private val moshi = Moshi.Builder()
    .add(KotlinJsonAdapterFactory())
    .build()

private val retrofit = Retrofit.Builder()
    .addConverterFactory(MoshiConverterFactory.create(moshi))
    .baseUrl(BASE_URL)
    .build()

val apiService: GdgService by lazy {
    retrofit.create(GdgService::class.java)
}