package com.project.newsapp.data.jp

import com.project.newsapp.data.BaseDataSource
import javax.inject.Inject

class JapaneseDataSource @Inject constructor(private val japaneseService: JapaneseService) :
    BaseDataSource() {

    suspend fun getJpNews() = getData { japaneseService.jpNews() }
}