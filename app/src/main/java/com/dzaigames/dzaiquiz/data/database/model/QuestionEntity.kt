package com.dzaigames.dzaiquiz.data.database.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.dzaigames.dzaiquiz.data.model.QuestionDto
import com.dzaigames.dzaiquiz.data.model.QuestionType

@Entity(tableName = "questions")
data class QuestionEntity(@PrimaryKey(autoGenerate = true)
                          @ColumnInfo val id: Int,
                          @ColumnInfo var question: String = "",
                          @ColumnInfo var isSolved: Boolean = false,
                          @ColumnInfo val type: QuestionType = QuestionType.Map,
                          @ColumnInfo var qnas: Map<String, String> = mutableMapOf(),
                          @ColumnInfo val createdAt: Long = 0,
                          @ColumnInfo val updatedAt: Long = 0
)

fun QuestionEntity.toDto(): QuestionDto {
    return QuestionDto(
        id = id,
        question = question,
        type = type,
        qnas = qnas,
        createdAt = createdAt,
        updatedAt = updatedAt
    )
}

