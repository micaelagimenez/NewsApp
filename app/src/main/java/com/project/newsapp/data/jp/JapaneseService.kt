package com.project.newsapp.data.jp

import retrofit2.Response
import retrofit2.http.GET

interface JapaneseService {
    @GET("/v2/top-headlines?country=jp&apiKey=77acc490875643c5b2328fb615e0cf83")
    suspend fun jpNews(): Response<JapaneseResponse>
}