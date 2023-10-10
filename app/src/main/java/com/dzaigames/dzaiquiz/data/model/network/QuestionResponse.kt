package com.dzaigames.dzaiquiz.data.model.network

import com.google.gson.annotations.SerializedName

data class QuestionResponse(
    @SerializedName("qnas")
    val qnas: Map<String, String>,
    @SerializedName("question")
    val question: String,
    @SerializedName("type")
    val questionType: String,
    @SerializedName("id")
    val id: Int,
    @SerializedName("created_at")
    val createdAt: Long,
    @SerializedName("updated_at")
    val updatedAt: Long
)
