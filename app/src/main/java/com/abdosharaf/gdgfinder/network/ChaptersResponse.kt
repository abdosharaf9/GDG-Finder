package com.abdosharaf.gdgfinder.network

data class ChaptersResponse(
    val `data`: List<ChapterData>,
    val filters_: Filters
)

data class ChapterData(
    val chapter_name: String,
    val cityarea: String,
    val country: String,
    val geo: Geo,
    val region: String,
    val website: String
)

data class Filters(
    val region: List<String>
)

data class Geo(
    val lat: Double,
    val lng: Double
)