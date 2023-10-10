package com.dzaigames.dzaiquiz.data.api

import com.dzaigames.dzaiquiz.data.model.QuestionDto
import kotlinx.coroutines.flow.Flow

interface QuestionApi {
    fun fetchQuestions(): Flow<List<QuestionDto>>
}