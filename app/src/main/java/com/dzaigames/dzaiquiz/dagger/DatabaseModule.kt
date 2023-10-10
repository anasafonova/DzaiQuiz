package com.dzaigames.dzaiquiz.dagger

import android.content.Context
import androidx.room.Room
import com.dzaigames.dzaiquiz.data.database.QuizDatabase
import com.dzaigames.dzaiquiz.data.database.dao.QuestionsDao
import dagger.Module
import dagger.Provides
import javax.inject.Singleton


@Module
class DatabaseModule {
    private lateinit var database: QuizDatabase

    @Singleton
    @Provides
    fun providesRoomDatabase(context: Context): QuizDatabase {
        database = Room.databaseBuilder(context, QuizDatabase::class.java, "quiz-database").build()
        return database
    }

    @Singleton
    @Provides
    fun providesQuizDao(database: QuizDatabase): QuestionsDao {
        return database.questionsDao()
    }
}
