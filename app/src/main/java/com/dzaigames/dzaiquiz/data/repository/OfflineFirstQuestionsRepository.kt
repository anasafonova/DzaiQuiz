package com.dzaigames.dzaiquiz.data.repository

import com.dzaigames.dzaiquiz.data.api.QuestionApi
import com.dzaigames.dzaiquiz.data.database.dao.QuestionsDao
import com.dzaigames.dzaiquiz.data.database.model.toDto
import com.dzaigames.dzaiquiz.data.model.QuestionDto
import com.dzaigames.dzaiquiz.data.model.toEntity
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

class OfflineFirstQuestionsRepository @Inject constructor(
    private val questionsDao: QuestionsDao,
    private val questionApi: QuestionApi
) : QuestionsRepository {

    override fun getQuestions(): Flow<List<QuestionDto>> {
        return questionsDao.questions()
            .flowOn(Dispatchers.IO)
            .map { questions ->
            questions.map { it.toDto() }
        }.onEach {
            if (it.isEmpty()) {
                refreshQuestions()
            }
        }
    }

    override suspend fun refreshQuestions() {
        questionApi.fetchQuestions()
            .flowOn(Dispatchers.IO)
            .also { questionFlow ->
                questionsDao.insertAllQuestions(items = questionFlow.map { questions ->
                    questions.map(QuestionDto::toEntity)
                }.first())
            }
    }
}