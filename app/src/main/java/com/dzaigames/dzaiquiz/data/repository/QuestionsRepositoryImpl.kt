package com.dzaigames.dzaiquiz.data.repository

import com.dzaigames.dzaiquiz.data.api.QuestionApi
import com.dzaigames.dzaiquiz.data.model.QuestionDto
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject

class QuestionsRepositoryImpl @Inject constructor(
    private val questionApi: QuestionApi
): QuestionsRepository {

    override fun getQuestions(): Flow<List<QuestionDto>>  =
        questionApi.fetchQuestions()
            .flowOn(Dispatchers.IO)

    override suspend fun refreshQuestions() {
        TODO("Not yet implemented")
    }
}