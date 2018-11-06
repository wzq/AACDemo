package com.wzq.aac.model

import com.google.gson.annotations.SerializedName

data class DetailExtra(
        val longComments: Int,
        val popularity: Int,

        @SerializedName("short_comments")
        val shortComments: Int,
        val comments: Int
)