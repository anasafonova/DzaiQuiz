package com.dzaigames.dzaiquiz.data.model

enum class QuestionType(
    val typeId: Int,
    val value: String
) {
    Order(typeId = 1, value = "order"),
    Map(typeId = 2, value = "map"),
    Cluster(typeId = 3, value = "cluster"),
    Timeline(typeId = 4, value = "timeline"),
    Unknown(typeId = -1, value = "unknown");
}

fun mapToQuestionType(typeCode: String): QuestionType =
    QuestionType.values().firstOrNull { it.value == typeCode.lowercase() } ?: QuestionType.Unknown

fun mapQuestionTypeIdToValue(id: Int): String =
    QuestionType.values().firstOrNull { it.typeId == id }?.value ?: QuestionType.Unknown.value