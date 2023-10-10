package com.dzaigames.dzaiquiz.data.database

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.dzaigames.dzaiquiz.data.database.dao.QuestionsDao
import com.dzaigames.dzaiquiz.data.database.model.QuestionEntity
import com.dzaigames.dzaiquiz.data.database.typeconverters.JsonMapConverter

@Database(
    entities = [QuestionEntity::class],

    version = QuizDatabase.DATABASE_VERSION,

    exportSchema = false
)
@TypeConverters(JsonMapConverter::class)
abstract class QuizDatabase : RoomDatabase() {

    abstract fun questionsDao() : QuestionsDao

    companion object {
        const val DATABASE_VERSION: Int = 1
    }

}