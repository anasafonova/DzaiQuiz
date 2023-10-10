package com.dzaigames.dzaiquiz.data.model

import com.dzaigames.dzaiquiz.data.database.model.QuestionEntity
import com.dzaigames.dzaiquiz.data.model.network.QuestionResponse

data class QuestionDto(
    val id: Int,
    var question: String = "",
    var isSolved: Boolean = false,
    val type: QuestionType = QuestionType.Map,
    var qnas: Map<String, String> = mutableMapOf(),
    val createdAt: Long = 0,
    val updatedAt: Long = 0
)

fun QuestionResponse.toDto(): QuestionDto {
    return QuestionDto(
        id = id,
        question = question,
        type = mapToQuestionType(questionType),
        qnas = qnas,
        createdAt = createdAt,
        updatedAt = updatedAt
    )
}

fun QuestionDto.toEntity(): QuestionEntity {
    return QuestionEntity(
        id = id,
        question = question,
        type = type,
        qnas = qnas,
        createdAt = createdAt,
        updatedAt = updatedAt
    )
}