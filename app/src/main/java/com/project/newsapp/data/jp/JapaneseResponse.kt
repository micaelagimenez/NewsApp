package com.project.newsapp.data.jp

import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.RawValue
import java.io.Serializable

data class JapaneseResponse(
    @SerializedName("status") var Status: String,
    @SerializedName("totalResults") var totalResults: Int,
    @SerializedName("articles") var Articles: List<ArticlesData>
) : Serializable

data class ArticlesData(
    @SerializedName("source") var Source: @RawValue SourceData,
    @SerializedName("author") var Author: String? = " ",
    @SerializedName("title") var Title: String,
    @SerializedName("description") var Description: String,
    @SerializedName("url") var Url: String,
    @SerializedName("urlToImage") var urlToImage: String? = " ",
    @SerializedName("publishedAt") var publishedAt: String,
    @SerializedName("content") var Content: String? = " "
) : Serializable

data class SourceData(
    @SerializedName("name") var Name: String,
) : Serializable