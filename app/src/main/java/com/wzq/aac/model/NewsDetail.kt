package com.wzq.aac.model

import com.google.gson.annotations.SerializedName

data class NewsDetail (
        val body: String,
        val title: String,
        val image: String,
        @SerializedName("share_url")
        val shareUrl: String,
        val id: Int,
        val images: List<String>,
        val css: List<String>,
        val type: Int,
        @SerializedName("recommenders")
        val writer: String
)