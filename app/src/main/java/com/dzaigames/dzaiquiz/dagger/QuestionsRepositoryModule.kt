package com.dzaigames.dzaiquiz.dagger

import com.dzaigames.dzaiquiz.data.api.QuestionApi
import com.dzaigames.dzaiquiz.data.database.dao.QuestionsDao
import com.dzaigames.dzaiquiz.data.repository.OfflineFirstQuestionsRepository
import com.dzaigames.dzaiquiz.data.repository.QuestionsRepository
import com.dzaigames.dzaiquiz.data.repository.QuestionsRepositoryImpl
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class QuestionsRepositoryModule {
    @Provides
    @Singleton
    fun provideQuestionsRepository(questionApi: QuestionApi, questionsDao: QuestionsDao): QuestionsRepository =
        OfflineFirstQuestionsRepository(questionsDao = questionsDao, questionApi = questionApi)
}