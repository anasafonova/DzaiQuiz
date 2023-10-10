package com.dzaigames.dzaiquiz.data.database.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.dzaigames.dzaiquiz.data.database.model.QuestionEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface QuestionsDao {

    @Query("select * from questions")
    fun questions(): Flow<List<QuestionEntity>>

    @Query("select * from questions where id = :id")
    fun questionById(id: Int): Flow<List<QuestionEntity>>

    @Query("SELECT * FROM questions WHERE isSolved = 0")
    fun unsolvedQuestions(): Flow<List<QuestionEntity>>

    @Query("UPDATE questions SET isSolved = 1 WHERE id = :id")
    fun markQuestionAsSolved(id: Int): Int

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAllQuestions(items: List<QuestionEntity>)
}