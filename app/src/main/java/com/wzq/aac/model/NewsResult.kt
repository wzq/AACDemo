package com.wzq.aac.model

import com.google.gson.annotations.SerializedName

data class NewsResult(

    val date: String,

    val stories: List<News>,

    @SerializedName("top_stories")
    val topics: List<News>
)