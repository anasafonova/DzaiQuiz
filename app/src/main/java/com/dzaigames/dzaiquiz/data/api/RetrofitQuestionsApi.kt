package com.dzaigames.dzaiquiz.data.api

import com.dzaigames.dzaiquiz.data.model.network.QuestionResponse
import retrofit2.http.GET

interface RetrofitQuestionApi {
    @GET("/api/v0.1/questions/")
    suspend fun fetchQuestions(): List<QuestionResponse>
}