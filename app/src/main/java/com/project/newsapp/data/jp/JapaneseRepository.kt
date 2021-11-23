package com.project.newsapp.data.jp

import javax.inject.Inject

class JapaneseRepository @Inject constructor(
    private val remote: JapaneseDataSource
) {
    suspend fun jpNews() =
        remote.getJpNews()
}