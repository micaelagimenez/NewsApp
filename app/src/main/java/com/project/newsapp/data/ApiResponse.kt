package com.project.newsapp.data

import com.google.gson.annotations.SerializedName

data class ApiResponse<T>(
    @SerializedName("success") var succes: Boolean,
    @SerializedName("data") var data: T,
    @SerializedName("message") var message: String
)