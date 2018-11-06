package com.wzq.aac.model

import com.google.gson.annotations.SerializedName

data class DetailResult(
        @SerializedName("CONTENTS")
        val contents: NewsDetail
)