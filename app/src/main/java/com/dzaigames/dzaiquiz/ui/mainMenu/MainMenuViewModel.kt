package com.dzaigames.dzaiquiz.ui.mainMenu

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.dzaigames.dzaiquiz.data.model.QuestionDto
import com.dzaigames.dzaiquiz.data.repository.QuestionsRepository
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.stateIn
import javax.inject.Inject

class MainMenuViewModel @Inject constructor(
    questionsRepository: QuestionsRepository
): ViewModel() {
    var questions: StateFlow<List<QuestionDto>> = questionsRepository
        .getQuestions()
        .stateIn(
            scope = viewModelScope,
            started = SharingStarted.Lazily,
            initialValue = listOf()
        )
}