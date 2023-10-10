package com.dzaigames.dzaiquiz.data.api

import com.dzaigames.dzaiquiz.data.model.QuestionDto
import com.dzaigames.dzaiquiz.data.model.QuestionType
import com.dzaigames.dzaiquiz.data.model.toDto
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import java.lang.Exception

class QuestionApiImpl(private val retrofitQuestionsApi: RetrofitQuestionsApi): QuestionApi {
    override fun fetchQuestions(): Flow<List<QuestionDto>> = flow {
        try {
            emit(retrofitQuestionsApi.fetchQuestions().map { it.toDto() })
        }
        catch (throwable: Exception) {
            throwable.printStackTrace()
            emit(
                listOf(
                    QuestionDto(
                        id = 1,
                        question = "Какое движение в этих странах?",
                        type = QuestionType.Cluster,
                        qnas = mapOf(
                            "Индия" to "Левостороннее",
                            "ЮАР" to "Левостороннее",
                            "Австралия" to "Левостороннее",
                            "Кения" to "Левостороннее",
                            "Тайланд" to "Левостороннее",
                            "Россия" to "Правостороннее",
                            "Бразилия" to "Правостороннее",
                            "Канада" to "Правостороннее",
                            "Судан" to "Правостороннее",
                            "Чили" to "Правостороннее",
                            "Кипр" to "Левостороннее"
                        )
                    ),
                    QuestionDto(
                        id = 2,
                        question = "Расположите африканские страны по убыванию площади территории",
                        type = QuestionType.Order,
                        qnas = mapOf(
                            "Алжир" to "0",
                            "Чад" to "1",
                            "Египет" to "2",
                            "Кения" to "3",
                            "Тунис" to "4"
                        )
                    ),
                    QuestionDto(
                        id = 3,
                        question = "Расположите острова по убыванию удалённости от ближайшего материка",
                        type = QuestionType.Order,
                        qnas = mapOf(
                            "Гавайские" to "0",
                            "Фиджи" to "1",
                            "Мадейра" to "2",
                            "Мадагаскар" to "3",
                            "Шри-Ланка" to "4"
                        )
                    )
                )
            )
        }
    }
}