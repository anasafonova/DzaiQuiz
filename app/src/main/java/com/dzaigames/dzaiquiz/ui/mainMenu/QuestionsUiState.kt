package com.dzaigames.dzaiquiz.ui.mainMenu

import androidx.compose.runtime.Immutable
import com.dzaigames.dzaiquiz.data.model.QuestionDto

@Immutable
sealed interface QuestionsUiState {
    data class Success(val questions: List<QuestionDto>) : QuestionsUiState
    object Loading : QuestionsUiState
    object Error : QuestionsUiState
}