package com.dzaigames.dzaiquiz.data.repository

import com.dzaigames.dzaiquiz.data.model.QuestionDto
import kotlinx.coroutines.flow.Flow

interface QuestionsRepository {

    fun getQuestions(): Flow<List<QuestionDto>>

    suspend fun refreshQuestions()

}